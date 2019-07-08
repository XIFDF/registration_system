package com.xifdf.registration_system.controller;

import com.xifdf.registration_system.pojo.School;
import com.xifdf.registration_system.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/school")
public class SchoolController {

    @Resource
    SchoolService schoolService;

    @GetMapping(value = "getallschool")
    public List<School> getAllSchool(){
        return schoolService.getAllSchool();
    }

    @PostMapping(value = "addschool")
    public int addSchool(@RequestParam("sname") String sname) {
        try {
            School school = new School();
            school.setSname(sname);
            return schoolService.addSchool(school);
        }catch (Exception e) {
            return 0;
        }
    }

    @PostMapping(value = "/deleteschool")
    public int addSchool(@RequestParam("sid") int sid) {
        try {
            return schoolService.deleteSchool(sid);
        }catch (Exception e) {
            return 0;
        }
    }
}
