package com.xifdf.registration_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {
    @RequestMapping("/index")
    public String mainpage() {
        return "这里是主页";
    }
}
