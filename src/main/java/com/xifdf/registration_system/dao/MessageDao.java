package com.xifdf.registration_system.dao;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageDao {
    //查询所有留言(分页)
    List<Message> queryMessageList();
    //查询考试留言(分页)
    List<Message> queryMessageByExam(int examid);
    //查询用户留言(分页)
    List<Message> queryMessageByUser(int userid);

    int queryAddMessage (@Param("userid") int userid, @Param("examid")int examid, @Param("says")String says);
    int queryDeleteMessage (int mid);
}
