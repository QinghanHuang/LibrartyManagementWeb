package com.library.entity;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/24 21:30
 * @Desc
 * @Version 1.0
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//if there is an auto increment data add a constructor and a  no args constructor
@Data
@NoArgsConstructor
public class Borrow {
    int borrowId ;
    int bid;
    String bookTitle;
    Date borrowDate;
    String studentName;
    int sid;

    public Borrow(int bid, String bookTitle, Date borrowDate, String studentName, int sid) {
        this.bid = bid;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.studentName = studentName;
        this.sid = sid;
    }
}
