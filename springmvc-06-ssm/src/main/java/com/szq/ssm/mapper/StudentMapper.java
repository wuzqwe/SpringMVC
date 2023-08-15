package com.szq.ssm.mapper;

import com.szq.ssm.pojo.Student;

import java.util.List;

public interface StudentMapper {

    int insertStudent(Student student);

    List<Student> selectStudents();
}
