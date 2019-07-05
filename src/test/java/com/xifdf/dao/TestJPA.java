package com.xifdf.dao;

import com.xifdf.registration_system.RegistrationSystemApplication;
import com.xifdf.registration_system.dao.ExamDao;
import com.xifdf.registration_system.dao.LogDao;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.pojo.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RegistrationSystemApplication.class)
public class TestJPA     {
    @Autowired
    LogDao logDao;
    @Autowired
    ExamDao examDao;
    @Test
    public void testAddLog(){
        Log log = new Log();
        log.setType("测试操作");
        log.setUserid(1);
        log.setTime(Timestamp.valueOf("2019-01-02 09:12:02"));
        logDao.queryAddLog(log);
    }

    @Test
    public void testGetLog(){
        List<Log> logList = logDao.queryLogList();
        System.out.println(logList);
    }

    @Test
    public void testGetExam(){
        Exam exam = examDao.queryExamById(2);
        System.out.println(exam.getDateTime());
    }
}
