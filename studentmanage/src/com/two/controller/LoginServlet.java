package com.two.controller;

import com.two.entity.User;
import com.two.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Path = request.getContextPath();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        LoginServiceImpl loginService = new LoginServiceImpl();
        List<User> login = loginService.login(username, password);
        String level = null;
        if (login != null) {
//            level = user.getLevel();
//            if (level.equals("用户")) {
//                request.getSession().setAttribute("user", user);
//                request.getRequestDispatcher("user.jsp").forward(request, response);
//            } else if (level.equals("管理员")) {
//                request.getSession().setAttribute("admin", user);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }
//        } else {
//            request.setAttribute("info", "错误;用户名或密码错误");
//            request.getRequestDispatcher("message.jsp").forward(request, response);
//        }
    }
}
