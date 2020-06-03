package com.maimai.mybatisgenerator.dao;

import com.maimai.mybatisgenerator.entity.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String stuid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String stuid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAll();

}