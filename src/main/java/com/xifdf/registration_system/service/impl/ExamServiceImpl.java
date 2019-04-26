package com.xifdf.registration_system.service.impl;

import com.xifdf.registration_system.dao.ExamDao;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.service.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Resource
    private ExamDao examDao;

    @Override
    public List<Exam> getExamList() {
        return examDao.queryExamList();
    }
}
