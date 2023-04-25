package com.library.service.impl;

import com.library.dao.StudentMapper;
import com.library.entity.Student;
import com.library.service.StudentService;
import com.library.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/25 12:49
 * @Desc
 * @Version 1.0
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudents() {
        StudentMapper studentMapper;
        try (SqlSession session = MybatisUtil.getSession()) {
            studentMapper = session.getMapper(StudentMapper.class);
            return studentMapper.getStudents();
        }
    }

    @Override
    public Student getStudent(int sid) {
        StudentMapper studentMapper;
        try (SqlSession session = MybatisUtil.getSession()) {
            studentMapper = session.getMapper(StudentMapper.class);
            return studentMapper.getStudent(sid);
        }
    }
}
