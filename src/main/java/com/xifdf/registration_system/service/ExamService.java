package com.xifdf.registration_system.service;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.pojo.Registration;

import java.util.List;


public interface ExamService {
    //获得所有考试(分页)
    PageInfo<Exam> getExamList(int pageNum);
    //获得即将过期考试项目
    PageInfo<Exam> getExpiringExams(int pageNum);
    //获得轮播考试项目(分页)
    List<Exam> getThreeNewExams();
    //获得过期考试项目(分页)
    PageInfo<Exam> getOverdueExams(int pageNum);
    Exam getExamById(int examid);
    List<Exam> getExamByName(String examname);
    PageInfo<Exam> getExamByUser(int userid, int pageNum);
    int addRegistration(int userid, int examid);
    int deleteRegistration(int userid, int examid);
    int addExam (Exam exam) throws Exception;
    int updateExam(Exam exam) throws Exception;
    int deleteExam(int examid) throws Exception;
}
