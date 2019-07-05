package com.xifdf.registration_system.dao;

import com.xifdf.registration_system.pojo.School;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolDao {
    //查询所有学校(分页)
    List<School> querySchoolList(int pageNum);
    List<School> queryAllSchool();
    School querySchoolByName(String sname);
    int queryAddSchool (School school);
    int queryUpdateSchool (School school);
    int queryDeleteSchool (int sid);
}
