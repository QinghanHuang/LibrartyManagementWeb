package com.library.test;

import com.library.dao.BookMapper;
import com.library.dao.StudentMapper;
import com.library.entity.Borrow;
import com.library.entity.Student;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.StudentServiceImpl;
import com.library.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/24 21:36
 * @Desc
 * @Version 1.0
 */
public class MapperTest {
    @Test
    public void getBorrowListTest(){
        SqlSession session = MybatisUtil.getSession();
        BookMapper bookMapper = session.getMapper(BookMapper.class);
        List<Borrow> borrowList = bookMapper.getBorrowList();
        System.out.println(borrowList);

    }
    @Test
    public void getStudentsTest(){
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.getStudents();
        System.out.println(students);

    }
    @Test
    public void getStudentTest(){
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.getStudent( 23);
        System.out.println(student);

    }
    @Test
    public void studentServiceTest(){
        StudentServiceImpl studentService = StudentServiceImpl.getInstance();
        List<Student> students = studentService.getStudents();
        System.out.println(students);

    }
    @Test
    public void bookServiceTest(){
        BookServiceImpl bookService =BookServiceImpl.getInstance();
        List<Borrow> borrowList = bookService.getBorrowList();
        System.out.println(borrowList);
    }

    @Test
    public void countTest(){
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        int s=studentMapper.countStudent();
        System.out.println(s);
    }
}
