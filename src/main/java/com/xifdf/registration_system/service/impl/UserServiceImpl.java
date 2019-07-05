package com.xifdf.registration_system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.dao.UserDao;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.pojo.User;
import com.xifdf.registration_system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public PageInfo<User> getUserList(int pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<User> users = userDao.queryUserList();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    @Override
    public User getUserByPid(String pid) {
        return null;
    }

    @Override
    public User getUserByUserid(int userid) {
        return userDao.queryUserByUserid(userid);
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public List<User> getUserByExam(int examId) {
        return userDao.queryUserByExam(examId);
    }

    //返回用户id登录成功, 0账号不存在或者密码错误, -1账号被禁用
    @Override
    public User userLogin(String email) {
        User user = userDao.queryUserByEmail(email);
        return user;
    }

    @Override
    public boolean userCheck(User user) {
        return false;
    }

    @Override
    public int register(User user) throws Exception {
        User newuser = userDao.queryUserByEmail(user.getEmail());
        if (newuser == null){
            userDao.queryAddUser(user);
            userDao.queryAddUserRole(userDao.queryUserByEmail(user.getEmail()).getUserid(), 1);
            return 1;
        }
        else return 0;
    }

    @Override
    public int updateUser(User user) throws Exception {
        return userDao.queryUpdateUser(user);
    }

    @Override
    public int deleteUser(User user) throws Exception {
        return 0;
    }
}
