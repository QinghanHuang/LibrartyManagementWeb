package com.library.util;

import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/22 21:25
 * @Desc
 * @Version 1.0
 */
public class MybatisUtil {
    private static SqlSessionFactory factory;
    static {
        try {
            factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSession(){
        return factory.openSession(true);
    }



}
