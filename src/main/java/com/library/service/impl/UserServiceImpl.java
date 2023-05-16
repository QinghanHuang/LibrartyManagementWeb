package com.library.service.impl;

import com.library.dao.UserMapper;
import com.library.entity.User;
import com.library.service.UserService;
import com.library.util.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/22 21:38
 * @Desc
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(username, password);
            if (user == null) {
                return false;
            }
            session.setAttribute("user", user);
            return true;
        }
    }
}
