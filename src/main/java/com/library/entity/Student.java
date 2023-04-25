package com.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/25 12:37
 * @Desc
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Student {
    int sid;
    String grade;
    String name;
    String sex;

    public Student(String grade, String name, String sex) {
        this.grade = grade;
        this.name = name;
        this.sex = sex;
    }
}
