package com.xifdf.registration_system.controller;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.Exam;
import com.xifdf.registration_system.service.ExamService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/exam")
public class ExamController {

    @Resource
    private ExamService examService;

    @GetMapping(value = "/getexams")
    public PageInfo<Exam> getAllExam(@RequestParam("pageNum") int pageNum) throws Exception{
        PageInfo<Exam> e = examService.getExamList(pageNum);
        return e;
    }

    @GetMapping(value = "/getexpiringexams")
    public PageInfo<Exam> getExpiringExams(@RequestParam("pageNum") int pageNum) throws Exception{
        return examService.getExpiringExams(pageNum);
    }

    @GetMapping(value = "/getexamsbyuser")
    public PageInfo<Exam> getExamByUser(@RequestParam("pageNum") int pageNum, HttpSession session) throws Exception{
        try {
            String string= session.getAttribute("userid").toString();
            return examService.getExamByUser(pageNum,Integer.parseInt(string));
        }catch (Exception e) {
            System.out.println("未登录访问");
            return null;
        }
    }

    @GetMapping(value = "/getexambyname")
    public List<Exam> getExamByName(@RequestParam("examname") String examname) throws Exception{
        List<Exam> exams = examService.getExamByName(examname);
        return exams;
}

    @PostMapping(value = "/addexam")
    public int examAdd(@RequestParam("beginTime") String beginTime,
                       @RequestParam("dateTime") String dateTime,
                       @RequestParam("endTime") String endTime,
                       @RequestParam("examName") String examName,
                       @RequestParam("site") String site, HttpSession session) throws Exception{
        try {
            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            Exam exam = new Exam();
            exam.setBeginTime(Timestamp.valueOf(beginTime.replace("T"," ")+":00"));
            exam.setEndTime(Timestamp.valueOf(endTime.replace("T"," ")+":00"));
            exam.setDateTime(Timestamp.valueOf(dateTime.replace("T"," ")+":00"));
            exam.setExamName(examName);
            exam.setSite(site);
            return examService.addExam(exam);
        }catch (Exception e){
            System.out.println("未登录请求");
        }
        return 0;
    }

    @PostMapping(value = "/updateexam")
    public int examUpdate(@RequestParam("examId") String examId,
                          @RequestParam("beginTime") String beginTime,
                       @RequestParam("dateTime") String dateTime,
                       @RequestParam("endTime") String endTime,
                       @RequestParam("examName") String examName,
                       @RequestParam("site") String site, HttpSession session) throws Exception{

            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            Exam exam = new Exam();
            exam.setExamId(Integer.parseInt(examId));
            String beginTimestamp = beginTime.replace("T"," ");
            String endTimestamp = endTime.replace("T"," ");
            String dateTimestamp = dateTime.replace("T"," ");
            if (beginTimestamp.length() == 19)
                exam.setBeginTime(Timestamp.valueOf(beginTimestamp));
            else
                exam.setBeginTime(Timestamp.valueOf(beginTimestamp + ":00"));
            if (endTimestamp.length() == 19)
                exam.setBeginTime(Timestamp.valueOf(endTimestamp));
            else
                exam.setBeginTime(Timestamp.valueOf(endTimestamp + ":00"));
            if (dateTimestamp.length() == 19)
                exam.setBeginTime(Timestamp.valueOf(dateTimestamp));
            else
                exam.setBeginTime(Timestamp.valueOf(dateTimestamp + ":00"));

            exam.setExamName(examName);
            exam.setSite(site);
            return examService.updateExam(exam);


    }

    @PostMapping(value = "/deleteexam")
    public int examDelete(@RequestParam("examId") String examId, HttpSession session) throws Exception{
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        return examService.deleteExam(Integer.parseInt(examId));
    }

    @PostMapping(value = "/addreg")
    public int regAdd(@RequestParam("examid") String examid, HttpSession session) {
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        return examService.addRegistration(userid, Integer.parseInt(examid));
    }

    @PostMapping(value = "/deletereg")
    public int regDelete(@RequestParam("examid") String examid, HttpSession session) {
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        return examService.deleteRegistration(userid, Integer.parseInt(examid));
    }
}
