package com.asylzhan.shop.JavaEE_midterm_shop.controller;

import com.asylzhan.shop.JavaEE_midterm_shop.dao.UserDao;
import com.asylzhan.shop.JavaEE_midterm_shop.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

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

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        try {
            if (userDao.validate(user)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
//                out.println("<center>\n<h1>You logged in " + name + " !</h1>");
//                response.sendRedirect("profile.jsp");
                RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
                rd.forward(request,response);
            } else {
                HttpSession session = request.getSession();
                response.sendRedirect("testing.jsp");
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        String n = request.getParameter("email");
//        String p = request.getParameter("password");
//
//        if (LoginDao.validate(n, p)) {
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
//        } else {
//            out.print("Sorry username or password error");
//            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//            rd.include(request, response);
//        }
//
//        out.close();
    }
}
