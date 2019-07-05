package com.xifdf.registration_system.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class PageController {
    @RequestMapping("/index")
    public String mainpage() {
        return "index";
    }

    @RequestMapping("/login")
    public String loginpage() {
        return "login";
    }

    @RequestMapping("/register")
    public String registerpage() {
        return "register";
    }

    @RequestMapping("/person")
    public String personpage(HttpSession session) {
        try{
            if (session.getAttribute("userrole").toString().equals("学生"))
                return "person";
            else return "index";
        }catch (Exception e){
            return "index";
        }
    }

    @RequestMapping("/admin")
    public String adminpage(HttpSession session) {
        try {
            if (session.getAttribute("userrole").toString().equals("管理员"))
                return "admin";
            else return "index";
        }catch (Exception e){
            return "index";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    public Object getSession(HttpSession session) {
        HashMap sessionMap = new HashMap();
        sessionMap.put("userid", session.getAttribute("userid"));
        sessionMap.put("username", session.getAttribute("username"));
        sessionMap.put("userrole", session.getAttribute("userrole"));
        return sessionMap;
    }
    @ResponseBody
    @RequestMapping(value = "/gettime", method = RequestMethod.GET)
    public Object getTime(HttpSession session) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
}
