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
public class Book {
    int bid;
    String title;
    double price;
    String bookInfo;

    public Book(String title, double price, String bookInfo) {
        this.title = title;
        this.price = price;
        this.bookInfo = bookInfo;
    }
}
