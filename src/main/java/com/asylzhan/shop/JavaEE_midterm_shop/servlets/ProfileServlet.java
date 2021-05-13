package com.asylzhan.shop.JavaEE_midterm_shop.servlets;

import com.asylzhan.shop.JavaEE_midterm_shop.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        String n=request.getParameter("email");
        out.print("Welcome "+n);
    }
}
