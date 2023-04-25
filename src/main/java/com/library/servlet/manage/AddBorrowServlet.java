package com.library.servlet.manage;

import com.library.entity.User;
import com.library.service.BookService;
import com.library.service.StudentService;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.StudentServiceImpl;
import com.library.util.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/25 12:10
 * @Desc
 * @Version 1.0
 */
@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {
    StudentService studentService;
    BookService bookService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentServiceImpl();
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());

        context.setVariable("student_list",studentService.getStudents());
        context.setVariable("active_book_list",bookService.getActivateBookList());
        ThymeleafUtil.process("add-borrow.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid = Integer.parseInt( req.getParameter("book"));
        int sid = Integer.parseInt( req.getParameter("student"));
        bookService.addBorrow(sid,bid);
        resp.sendRedirect("index");
    }
}
