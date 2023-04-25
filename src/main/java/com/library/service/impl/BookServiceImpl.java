package com.library.service.impl;

import com.library.dao.BookMapper;
import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.service.BookService;
import com.library.util.MybatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/24 22:04
 * @Desc
 * @Version 1.0
 */
public class BookServiceImpl implements BookService {
    @Override
    public List<Borrow> getBorrowList() {
        BookMapper bookMapper;
        try (SqlSession session = MybatisUtil.getSession()) {
            bookMapper = session.getMapper(BookMapper.class);
            List<Borrow> borrowList = bookMapper.getBorrowList();
            return borrowList;

        }
    }

    @Override
    public boolean returnBook(String id) {
        BookMapper bookMapper;
        try (SqlSession session = MybatisUtil.getSession()) {
            bookMapper = session.getMapper(BookMapper.class);
            boolean flag = bookMapper.returnBook(id);
            return flag;
        }
    }

    @Override
    public List<Book> getActivateBookList() {
        BookMapper bookMapper;
        try (SqlSession session = MybatisUtil.getSession()) {
            bookMapper = session.getMapper(BookMapper.class);
            return bookMapper.getActiveBookList();
        }
    }

    @Override
    public List<Book> getBookList() {
        BookMapper bookMapper;
        try (SqlSession session = MybatisUtil.getSession()) {
            bookMapper = session.getMapper(BookMapper.class);
            return bookMapper.getBookList();
        }
    }

    @Override
    public boolean addBorrow(int sid, int bid) {
        BookMapper bookMapper;
        try (SqlSession session = MybatisUtil.getSession()) {
            bookMapper = session.getMapper(BookMapper.class);
            return bookMapper.addBorrow(sid, bid);
        }
    }


}
