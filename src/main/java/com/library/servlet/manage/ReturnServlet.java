package com.library.servlet.manage;

import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/24 22:25
 * @Desc
 * @Version 1.0
 */
@WebServlet("/return-book")
public class ReturnServlet extends HttpServlet {
     BookService bookService=BookServiceImpl.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        bookService.returnBook(id);

        resp.sendRedirect("index");

    }
}
