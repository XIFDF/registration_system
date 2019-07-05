package com.xifdf.registration_system.dao;

import com.xifdf.registration_system.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface LogDao {
    //增加日志条目
    int queryAddLog(Log log);

    List<Log> queryLogList();
}
