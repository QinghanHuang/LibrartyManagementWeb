package com.library.servlet.page;

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
 * @Date 2023/4/23 14:31
 * @Desc
 * @Version 1.0
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {

    BookService bookService=BookServiceImpl.getInstance();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());
        context.setVariable("book_map_status",bookService.getBookListWithStatus());

        ThymeleafUtil.process("book.html", context, resp.getWriter());
    }
}
