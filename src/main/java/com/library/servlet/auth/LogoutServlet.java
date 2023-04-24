package com.library.servlet.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/23 11:35
 * @Desc
 * @Version 1.0
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //clear session attribute-user
        req.getSession().removeAttribute("user");

        // redirect to log in
        resp.sendRedirect("login");
    }
}
