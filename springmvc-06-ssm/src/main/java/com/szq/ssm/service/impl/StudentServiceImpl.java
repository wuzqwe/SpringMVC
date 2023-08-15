package com.szq.ssm.service.impl;

import com.szq.ssm.mapper.StudentMapper;
import com.szq.ssm.pojo.Student;
import com.szq.ssm.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int addStudent(Student student) {
        int count = studentMapper.insertStudent(student);

        return count;
    }

    @Override
    public List<Student> findStudents() {
        return studentMapper.selectStudents();
    }
}
