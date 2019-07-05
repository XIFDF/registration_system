package com.xifdf.registration_system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.dao.ExamDao;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.pojo.Registration;
import com.xifdf.registration_system.service.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ExamServiceImpl implements ExamService {

    @Resource
    private ExamDao examDao;

    @Override
    public PageInfo<Exam> getExamList(int pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<Exam> exams = examDao.queryExamList();
        PageInfo<Exam> examPageInfo = new PageInfo<>(exams);
        return examPageInfo;
    }

    @Override
    public PageInfo<Exam> getExpiringExams(int pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<Exam> exams = examDao.queryExpiringExams();
        PageInfo<Exam> examPageInfo = new PageInfo<>(exams);
        return examPageInfo;
    }

    @Override
    public List<Exam> getThreeNewExams() {
        return null;
    }

    @Override
    public PageInfo<Exam> getOverdueExams(int pageNum) {
        return null;
    }

    @Override
    public Exam getExamById(int examid) {
        return null;
    }

    @Override
    public List<Exam> getExamByName(String examname) {
        return examDao.queryExamByName(examname);
    }

    @Override
    public PageInfo<Exam> getExamByUser(int pageNum, int userid) {
        PageHelper.startPage(pageNum, 8);
        List<Exam> exams = examDao.queryExamByUserid(userid);
        PageInfo<Exam> examPageInfo = new PageInfo<>(exams);
        return examPageInfo;
    }

    @Override
    public int addRegistration(int userid, int examid) {
        Registration reg = new Registration();
        reg.setUserid(userid);
        reg.setExamid(examid);
        try {
            return examDao.queryAddRegistration(reg);
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public int deleteRegistration(int userid, int examid) {
        Registration reg = new Registration();
        reg.setUserid(userid);
        reg.setExamid(examid);
        return examDao.queryDeleteRegistration(reg);
    }

    @Override
    public int addExam(Exam exam) throws Exception {
        return examDao.queryAddExam(exam);
    }

    @Override
    public int updateExam(Exam exam) throws Exception {
        return examDao.queryUpdateExam(exam);
    }

    @Override
    public int deleteExam(int examid) throws Exception {
        return examDao.queryDeleteExam(examid);
    }
}
