package com.library.servlet.manage;

import com.library.entity.User;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;
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
@WebServlet("/add-book")
public class AddBookServlet extends HttpServlet {
    BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());

        ThymeleafUtil.process("add-book.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String bookInfo = req.getParameter("bookInfo");
        double price = Double.parseDouble(req.getParameter("price"));
        bookService.addBook(title,bookInfo,price);
        resp.sendRedirect("book");

    }
}
