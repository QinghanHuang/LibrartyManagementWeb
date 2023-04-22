package com.library.test;

import com.library.dao.UserMapper;
import com.library.entity.User;
import com.library.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/22 23:04
 * @Desc
 * @Version 1.0
 */
public class MybatisTest {
    @Test
    public void mybatisTest(){
        SqlSession session = MybatisUtil.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User admin = mapper.getUser("admin", "123456");
        System.out.println(admin);

    }
}
