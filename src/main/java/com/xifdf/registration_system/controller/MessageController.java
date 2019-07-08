package com.xifdf.registration_system.controller;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.Message;
import com.xifdf.registration_system.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @GetMapping(value = "/getallmessage")
    private PageInfo<Message> getAllMessage(@RequestParam("pageNum") int pageNum, HttpSession session) {
        return messageService.getMessageList(pageNum);
    }

    @GetMapping(value = "/getmessagesbyuser")
    private PageInfo<Message> getMessagesByUser(@RequestParam("pageNum") int pageNum, HttpSession session) {
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        return messageService.getMessageByUser(pageNum, userid);
    }

    @PostMapping(value = "/deletemessage")
    private int deleteMessage(@RequestParam("mid") String mid, @RequestParam("userid") String userid, HttpSession session) throws Exception{
        try {
            if(session.getAttribute("userid").toString().equals(userid)) {
                return messageService.deleteMessage(Integer.parseInt(mid));
            }
        }catch (Exception e) {
            System.out.println("未登录请求:留言删除");
        }
        return 0;
    }
    @PostMapping(value = "/addmessage")
    private int addMessage(@RequestParam("examid") String examid, @RequestParam("says") String says, HttpSession session) throws Exception{
        try {
            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            return messageService.addMessage(userid, Integer.parseInt(examid), says);

        }catch (Exception e) {
            System.out.println("未登录请求:添加留言");
        }
        return 0;
    }
}
