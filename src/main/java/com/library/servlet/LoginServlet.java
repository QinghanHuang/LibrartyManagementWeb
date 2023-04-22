package com.library.servlet;

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
 * @Date 2023/4/21 22:15
 * @Desc For login
 * @Version 1.0
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService service;

    // initial UserService
    @Override
    public void init() throws ServletException {
        service=new UserServiceImpl();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // use a thymeleaf context to pass param
        Context context=new Context();

        // if this session has login-failure flag
        if(req.getSession().getAttribute("login-failure")!=null){

            //change the context map "failure"-true
            context.setVariable("failure",true);

            //clear this "login-failure" Attribute
            //Or it will maintain "login-failure"
            req.getSession().removeAttribute("login-failure");
        }

        ThymeleafUtil.process("login.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //from html post ger user info
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String remember=req.getParameter("remember-me");

        //use UserService auth() to determine whether login success
        if(service.auth(username,password,req.getSession())){

            // condition login success
            resp.getWriter().write("Login Success");
        }else{

            //login fail  --> to set an Attribute in Session(like flag) to indicate this session login fail
            req.getSession().setAttribute("login-failure",new Object());

            // pass this to doGet to fresh the page and show the password is wrong
            this.doGet(req,resp);
        }
    }
}
