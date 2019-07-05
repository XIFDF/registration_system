package com.xifdf.registration_system.dao;


import com.xifdf.registration_system.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    User queryUserByEmail(String email);
    User queryUserByUserid(int userid);
    List<User> queryUserByExam(int examId);
    List<User> queryUserList();

    int queryAddUser(User user);
    int queryAddUserRole(@Param("uid") int uid, @Param("rid") int rid);
    int queryUpdateUser(User user);
}
