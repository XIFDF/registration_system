package com.xifdf.registration_system.dao;

import com.xifdf.registration_system.pojo.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamDao {
    //获取考试项目
    List<Exam> queryExamList();

}
