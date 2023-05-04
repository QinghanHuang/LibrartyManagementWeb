package com.library.servlet.manage;

import com.library.entity.Student;
import com.library.entity.User;
import com.library.service.StudentService;
import com.library.service.impl.StudentServiceImpl;
import com.library.util.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/29 12:55
 * @Desc
 * @Version 1.0
 */
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
    StudentService studentService = StudentServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());

        ThymeleafUtil.process("add-student.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String grade=req.getParameter("grade");
        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        studentService.addStudent(name,sex,grade);
        resp.sendRedirect("student");

    }
}
