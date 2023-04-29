package com.library.servlet.manage;

import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;
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
@WebServlet("/delete-book")
public class DeleteBookServlet  extends HttpServlet {
    BookService bookService= BookServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid =Integer.parseInt(req.getParameter("bid")) ;
        bookService.deleteBook(bid);
        resp.sendRedirect("book");


    }
}
