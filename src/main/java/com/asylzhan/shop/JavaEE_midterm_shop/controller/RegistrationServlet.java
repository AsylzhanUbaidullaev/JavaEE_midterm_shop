package com.asylzhan.shop.JavaEE_midterm_shop.controller;

import com.asylzhan.shop.JavaEE_midterm_shop.dao.UserDao;
import com.asylzhan.shop.JavaEE_midterm_shop.model.User;
import org.h2.engine.Session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        String login = request.getParameter("email");
//        String fullName = request.getParameter("name");
//        String password = request.getParameter("password");
//        String repassword = request.getParameter("repassword");
//
//        if (password.equals(repassword) && !login.isEmpty() && !password.isEmpty()) {
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//            System.out.println("You registered");
//        } else {
//            out.println("<center>\n<h1>You registered in " + login + " !</h1>");
//            out.println("<h2><a href='index.jsp'>Back to main page</a></h2>\n</center>");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        try {
            userDao.registerUser(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("index.jsp").
                    forward(request,response);

        } catch (Exception e) {

            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");
    }
}
