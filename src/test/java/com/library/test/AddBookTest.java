package com.library.test;

import com.library.dao.BookMapper;
import com.library.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/29 14:13
 * @Desc
 * @Version 1.0
 */
public class AddBookTest {
    @Test
    public void test(){
        SqlSession session = MybatisUtil.getSession();
        BookMapper bookMapper = session.getMapper(BookMapper.class);
        bookMapper.addBook("the cs","CS",12.50);

    }
}
