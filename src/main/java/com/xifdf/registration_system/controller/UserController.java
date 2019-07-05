package com.xifdf.registration_system.controller;


import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.pojo.User;
import com.xifdf.registration_system.service.SchoolService;
import com.xifdf.registration_system.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private SchoolService schoolService;

    @GetMapping(value = "/getuserconfig")
    public User getUser(HttpSession session){
        User user = userService.getUserByUserid(Integer.parseInt(session.getAttribute("userid").toString()));
        user.setPassword("");
        return user;
    }

    @GetMapping(value = "/getuserbyexam")
    public List<User> getUser(@RequestParam("examId") String examId){
        return userService.getUserByExam(Integer.parseInt(examId));
    }

    @PostMapping(value = "/login")
    public int userLogin(@RequestParam("email") String email, @RequestParam("password") String password,
                         HttpSession session){
        User user = userService.userLogin(email);
        if(user != null && user.getPassword().equals(password)) {
            if(user.getStatus() == -1)
                return -1;
            session.setAttribute("userid", user.getUserid());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userrole", user.getRole());
            session.setAttribute("status", user.getStatus());
            return 1;
        }
        else return 0;
    }

    @PostMapping(value = "/logout")
    public int userLogout(HttpSession session) {
        session.removeAttribute("userid");
        session.removeAttribute("username");
        session.removeAttribute("status");
        return 1;
    }

    @PostMapping(value = "/register")
    public int userRegister(@RequestParam("name") String name, @RequestParam("email") String email,
                            @RequestParam("password") String password) throws Exception {

        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        return userService.register(user);
    }

    @PostMapping(value = "/updateuser")
    public int userUpdate(@RequestParam("username") String username, @RequestParam("sid") String sid,
                          @RequestParam("pid") String pid, @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          HttpSession session) throws Exception {
        User user = userService.getUserByUserid(Integer.parseInt(session.getAttribute("userid").toString()));
        user.setUsername(username);
        user.setSid(schoolService.getSchoolByName(sid).getSid());
        user.setPid(pid);
        user.setEmail(email);
        if (!password.isEmpty())
            user.setPassword(password);
        return userService.updateUser(user);
    }

    @PostMapping(value = "/banuser")
    public int userBan(@RequestParam("userid") String userid,
                          HttpSession session) throws Exception {
        User user = userService.getUserByUserid(Integer.parseInt(userid));
        user.setStatus(-1);
        return userService.updateUser(user);
    }

    @PostMapping(value = "/startuser")
    public int userStart(@RequestParam("userid") String userid,
                          HttpSession session) throws Exception {
        User user = userService.getUserByUserid(Integer.parseInt(userid));
        user.setStatus(1);
        return userService.updateUser(user);
    }

    @GetMapping(value = "/getusers")
    public PageInfo<User> getUsers(@RequestParam("pageNum") int pageNum) throws Exception{
        PageInfo<User> e = userService.getUserList(pageNum);
        return e;
    }

    @PostMapping("/upload")
    public Object upload(@RequestParam(value = "file") MultipartFile file){
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
        String filePath = "C:/Users/23988/Desktop/registration_system/src/main/resources/static/assets/headpic";
        try {
            //将图片保存到static文件夹里
            file.transferTo(new File(filePath+fileName));
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

