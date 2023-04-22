package com.library.filter;

import com.library.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/21 22:36
 * @Desc 1.filter static request to pass
 * 2. If user did not log in redirect to log in html
 * 3. after log in  can pass
 * @Version 1.0
 */

@WebFilter("/*")
public class MainFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String url = req.getRequestURL().toString();

        //not static not login block!
        if (!url.contains("/static/") && !url.endsWith("login")) {

            //from request get session
            HttpSession session = req.getSession();

            //from session attribute get user
            User user = (User) session.getAttribute("user");

            //determine if redirect
            if (user == null) {
                // caution!!! the url without / or this url will begin http://localhost:8080
                res.sendRedirect("/library/login");
                return;
            }
        }
        //or pass
        chain.doFilter(req, res);

    }
}
