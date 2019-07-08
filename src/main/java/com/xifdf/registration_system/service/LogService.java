package com.xifdf.registration_system.service;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.Log;

public interface LogService {
    int addLog(Log log);
    PageInfo<Log> getLogs(int pageNum);
}
