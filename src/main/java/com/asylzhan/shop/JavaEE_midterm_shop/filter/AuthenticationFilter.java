package com.asylzhan.shop.JavaEE_midterm_shop.filter;

import com.asylzhan.shop.JavaEE_midterm_shop.dao.UserDao;
import com.asylzhan.shop.JavaEE_midterm_shop.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    private UserDao userDao;
    public void init(FilterConfig config) throws ServletException {
        userDao = new UserDao();
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println(" doFilter method is called in "
                + this.getClass().getName() + "\n\n");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email.equals("admin@gmail.com") && password.equals("admin")) {
            // sends request to next resource
//            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
//            rd.forward(request,response);
            chain.doFilter(request, response);

//            if(true){
//                chain.doFilter(request, response);
//            } else {
//                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
//                rd.forward(request,response);
//                System.out.println("qwerty");
//            }


        } else {
//            out.print("username or password is not correct!");
//            String email = request.getParameter("email");
//            String name = request.getParameter("firstName");
//            String password = request.getParameter("password");
            User user = new User();
//            user.setFirstName(name);
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
//                    HttpSession session = request.getSession();
//                    response.sendRedirect("testing.jsp");
                    //session.setAttribute("user", username);
                    //response.sendRedirect("login.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
