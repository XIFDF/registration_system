package com.xifdf.registration_system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.dao.MessageDao;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.pojo.Message;
import com.xifdf.registration_system.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    MessageDao messageDao;

    @Override
    public PageInfo<Message> getMessageList(int pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<Message> messages = messageDao.queryMessageList();
        PageInfo<Message> messagePageInfo = new PageInfo<>(messages);
        return messagePageInfo;
    }

    @Override
    public PageInfo<Message> getMessageByExam(String examname) {
        return null;
    }

    @Override
    public PageInfo<Message> getMessageByUser(int pageNum, int userid) {
        PageHelper.startPage(pageNum, 8);
        List<Message> messages = messageDao.queryMessageByUser(userid);
        PageInfo<Message> messagePageInfo = new PageInfo<>(messages);
        return messagePageInfo;
    }

    @Override
    public int addMessage(int userid, int examid, String says) throws Exception {
        return messageDao.queryAddMessage(userid, examid, says);
    }

    @Override
    public int deleteMessage(int mid) throws Exception {
        return messageDao.queryDeleteMessage(mid);
    }
}
