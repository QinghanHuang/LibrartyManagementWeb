package com.library.servlet.page;

import com.library.entity.User;
import com.library.util.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.thymeleaf.context.Context;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/23 14:19
 * @Desc
 * @Version 1.0
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());

        ThymeleafUtil.process("student.html", context, resp.getWriter());
    }
}
