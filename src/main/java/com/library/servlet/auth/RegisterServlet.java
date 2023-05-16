package com.library.servlet.auth;

import com.library.service.UserService;
import com.library.service.impl.UserServiceImpl;
import com.library.util.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/23 11:35
 * @Desc
 * @Version 1.0
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService service= UserServiceImpl.getInstance();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // use a thymeleaf context to pass param
        Context context=new Context();
        if(req.getSession().getAttribute("username-failure")!=null){

            //change the context map "failure"-true
            context.setVariable("user-exit",true);

            req.getSession().removeAttribute("username-failure");
        }

        if(req.getSession().getAttribute("password-failure")!=null){

            //change the context map "failure"-true
            context.setVariable("password-too-short",true);

            req.getSession().removeAttribute("password-failure");
        }


        ThymeleafUtil.process("register.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //from html post ger user info
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");

        // user already exit
        if(true){

            req.getSession().setAttribute("username-failure",new Object());
            this.doGet(req,resp);

        }
        //pass word less than 8
        if(password.length()<8){
            req.getSession().setAttribute("password-failure",new Object());
            this.doGet(req,resp);

        }
        //set new user to db

        //redirect to index
        resp.sendRedirect("index");
    }
}

