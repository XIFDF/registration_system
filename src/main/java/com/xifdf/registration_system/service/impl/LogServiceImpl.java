package com.xifdf.registration_system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.dao.LogDao;
import com.xifdf.registration_system.pojo.Log;
import com.xifdf.registration_system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;

    @Override
    public int addLog(Log log) {
        return logDao.queryAddLog(log);
    }

    @Override
    public PageInfo<Log> getLogs(int pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<Log> logs = logDao.queryLogList();
        PageInfo<Log> logPageInfo = new PageInfo<>(logs);
        return logPageInfo;
    }
}
