package com.library.dao;

import com.library.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    @Results({
            @Result(column = "sid",property = "sid"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "s_name",property = "name"),
            @Result(column = "sex",property = "sex")
    })
    @Select("select * from student ")
    List <Student> getStudents();


    @Results({
            @Result(column = "sid",property = "sid"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "s_name",property = "name"),
            @Result(column = "sex",property = "sex")
    })
    @Select("select * from student where sid=#{sid}")
    Student getStudent(int sid);

    @Delete("delete from student where sid=#{sid}")
    boolean deleteStudent(int sid);

    @Insert("insert into student(s_name,sex,grade) values(#{name},#{sex},#{grade})")
    boolean addStudent(@Param("name")String name,@Param("sex")String sex,@Param("grade")String grade);

    @Select("select count(*) from student")
    int countStudent();
}
