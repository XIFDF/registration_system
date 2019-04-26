package com.xifdf.registration_system.controller;

import com.xifdf.registration_system.dao.ExamDao;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/exam")
public class ExamController {

    @Resource
    private ExamService examService;

    @GetMapping(value = "/getallexam")
    public List<Exam> getAllExam(){
        return examService.getExamList();
    }
}
