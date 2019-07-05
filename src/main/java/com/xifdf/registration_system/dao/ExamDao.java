package com.xifdf.registration_system.dao;

import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.pojo.Registration;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamDao {
    //查询所有考试项目
    List<Exam> queryExamList();
    //查询即将过期考试项目
    List<Exam> queryExpiringExams();
    //查询轮播考试项目
    List<Exam> queryThreeNewExams();
    //查询过期考试项目
    List<Exam> queryOverdueExams();

    Exam queryExamById(int examid);
    List<Exam> queryExamByName(String examname);
    List<Exam> queryExamByUserid(int userid);
    int queryAddRegistration(Registration reg);
    int queryDeleteRegistration(Registration reg);

    int queryAddExam (Exam exam);
    int queryUpdateExam(Exam exam);
    int queryDeleteExam(int examid);

}
