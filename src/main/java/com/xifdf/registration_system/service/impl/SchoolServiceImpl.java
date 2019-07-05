package com.xifdf.registration_system.service.impl;

import com.github.pagehelper.PageInfo;
import com.xifdf.registration_system.dao.SchoolDao;
import com.xifdf.registration_system.pojo.School;
import com.xifdf.registration_system.service.SchoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    SchoolDao schoolDao;

    @Override
    public PageInfo<School> getSchoolList(int pageNum) {
        return null;
    }

    @Override
    public List<School> getAllSchool() {
        return schoolDao.queryAllSchool();
    }

    @Override
    public School getSchoolByName(String sname) {
        return schoolDao.querySchoolByName(sname);
    }

    @Override
    public int addSchool(School school) throws Exception {
        return schoolDao.queryAddSchool(school);
    }

    @Override
    public int updateSchool(School school) throws Exception {
        return 0;
    }

    @Override
    public int deleteSchool(int sid) throws Exception {
        return 0;
    }
}
