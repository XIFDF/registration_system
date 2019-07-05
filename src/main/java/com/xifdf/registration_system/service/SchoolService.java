package com.xifdf.registration_system.service;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.pojo.School;

import java.util.List;

public interface SchoolService {
    //获得所有学校(分页)
    PageInfo<School> getSchoolList(int pageNum);

    List<School> getAllSchool();
    School getSchoolByName(String sname);
    int addSchool (School school) throws Exception;
    int updateSchool (School school) throws Exception;
    int deleteSchool (int sid) throws Exception;
}
