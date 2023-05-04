package com.library.service;

import com.library.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudent(int sid);
    boolean deleteStudent(int sid);
    boolean addStudent(String name,String sex,String grade);
    int countStudent();
}
