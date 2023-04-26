package com.library.test;

import com.library.entity.Book;
import com.library.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/26 14:49
 * @Desc
 * @Version 1.0
 */
public class GetBookListWithStatusTest {
    @Test
    public void getBookListWithStatusTest(){
        BookServiceImpl bookService = new BookServiceImpl();
        Map<Book, Boolean> bookListWithStatus = bookService.getBookListWithStatus();
        System.out.println(bookListWithStatus);

    }
}
