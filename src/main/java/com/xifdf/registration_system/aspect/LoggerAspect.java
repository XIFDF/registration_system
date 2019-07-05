package com.xifdf.registration_system.aspect;

import com.xifdf.registration_system.dao.LogDao;
import com.xifdf.registration_system.pojo.Log;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component

public class LoggerAspect {
    @Autowired
    LogDao logDao;

    private static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
    private static HttpSession getSession(){
        return getRequest().getSession();
    }

    @Pointcut("execution(public * com.xifdf.registration_system.service.*.deleteSchool(..))")
    public void deleteschoolcut(){}

    @After("deleteschoolcut()")
    public void deleteSchoolLogger() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HttpSession session = LoggerAspect.getSession();
        Log log = new Log();
        log.setUserid(Integer.parseInt(session.getAttribute("userid").toString()));
        log.setType("删除学校");
        log.setTime(Timestamp.valueOf(df.format(new Date())));
        logDao.queryAddLog(log);
    }
}
