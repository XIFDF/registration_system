package com.xifdf.registration_system.controller;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.Log;
import com.xifdf.registration_system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/log")
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping(value = "/getlogs")
    public PageInfo<Log> getLogs(@RequestParam("pageNum") int pageNum) {
        return logService.getLogs(pageNum);
    }
}
