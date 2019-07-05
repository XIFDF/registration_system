package com.xifdf.registration_system.service;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.User;

import java.util.List;

public interface UserService {
    //获得所有用户(分页)
    PageInfo<User> getUserList(int pageNum);
    //用户查询
    User getUserByPid(String pid);
    User getUserByUserid(int userid);
    User getUserByName(String name);
    List<User> getUserByExam(int examId);
    //登录验证&身份验证
    User userLogin(String email);
    boolean userCheck(User user);
    //用户注册
    int register(User user) throws Exception;
    //更新用户信息
    int updateUser(User user) throws Exception;
    //删除用户
    int deleteUser(User user) throws Exception;
}
