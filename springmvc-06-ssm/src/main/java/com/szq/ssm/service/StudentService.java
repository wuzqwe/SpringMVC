package com.szq.ssm.service;

import com.szq.ssm.pojo.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);
    List<Student> findStudents();
}
