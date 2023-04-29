package com.library.servlet.manage;

import com.library.service.StudentService;
import com.library.service.impl.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/29 12:19
 * @Desc
 * @Version 1.0
 */
@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet {
    StudentService studentService = StudentServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        studentService.deleteStudent(sid);
        resp.sendRedirect("student");
    }
}
