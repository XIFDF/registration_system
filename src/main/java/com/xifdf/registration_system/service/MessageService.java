package com.xifdf.registration_system.service;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.Message;


public interface MessageService {
    //获得所有留言(分页)
    PageInfo<Message> getMessageList(int pageNum);
    //获得考试留言(分页)
    PageInfo<Message> getMessageByExam(String examname);
    //获得用户留言(分页)
    PageInfo<Message> getMessageByUser(int pageNum, int userid);

    int addMessage (int userid, int examid, String says) throws Exception;
    int deleteMessage (int mid) throws Exception;
}
