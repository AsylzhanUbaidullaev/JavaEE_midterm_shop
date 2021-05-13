package com.asylzhan.shop.JavaEE_midterm_shop.old_testing_servlets;

import com.asylzhan.shop.JavaEE_midterm_shop.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DisplayProductsServlet", value = "/DisplayProductsServlet")
public class DisplayProductsServlet extends HttpServlet {
    int added_cart_product = 0;
    Cookie c = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
//            Connection connection = ConnectDB.connect();
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020"
            );
            String sql = "select * from products";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            try {
                c = new Cookie(request.getParameter("id"), "1");
                response.addCookie(c);
//                HttpSession httpSession = request.getSession();
//                User user = (User) httpSession.getAttribute("user");
                pw.print("Product Added in To Cart Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
            pw.print("<a href='ViewCartProductsServlet'>View Cart</a>");
            pw.print(
                    "<style>"
                    + "td,th{padding:14px 30px}"
                    + "a:hover{color:red}"
                    + "</style>"

                    +"<table>"
                    +"<tr>"
                    +"<th>Id</th>"
                    +"<th>Product Name</th>"
                    +"<th>Price</th>"
            );
            while (rs.next()) {
                pw.print("<tr><td>" + rs.getInt("id") + "</td>"
                + "<td>" + rs.getString("name") + "</td>"
                        + "<td>" + rs.getString("price") + "</td>"
                        + "<td><a href='DisplayProductsServlet?id=" + rs.getInt(1) + "'>Add to cart</a></td>"
                        + "</tr><br><br>");

            }
            pw.print("</table></body></html>");
            pw.print("<a href='index.jsp'>Home</a>");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
