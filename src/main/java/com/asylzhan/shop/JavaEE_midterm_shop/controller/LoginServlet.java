package com.asylzhan.shop.JavaEE_midterm_shop.controller;

import com.asylzhan.shop.JavaEE_midterm_shop.dao.UserDao;
import com.asylzhan.shop.JavaEE_midterm_shop.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        UserDao userDao = new UserDao();
        try {

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userDao.validate(email, password);


            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                response.sendRedirect("profile.jsp");
            } else {
                HttpSession session = request.getSession();
                response.sendRedirect("error.jsp");
            }
        } catch (ClassNotFoundException | SQLException exception) {
            throw new ServletException(exception);
        }
    }
}
