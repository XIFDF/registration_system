package com.xifdf.dao;

import com.xifdf.registration_system.RegistrationSystemApplication;
import com.xifdf.registration_system.controller.SchoolController;
import com.xifdf.registration_system.dao.ExamDao;
import com.xifdf.registration_system.dao.LogDao;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.pojo.Log;
import com.xifdf.registration_system.pojo.School;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RegistrationSystemApplication.class)
public class TestJPA     {
    @Autowired
    private LogDao logDao;
    @Autowired
    private ExamDao examDao;
    @Autowired
    private SchoolController schoolController;

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(
                schoolController).build();
    }

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

    @Test
    public void testSchoolController() throws Exception{
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/school/deleteschool");
        requestBuilder.param("sid", "1");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String content = result.getResponse()
                .getContentAsString();
        System.out.println(content);
    }
}
