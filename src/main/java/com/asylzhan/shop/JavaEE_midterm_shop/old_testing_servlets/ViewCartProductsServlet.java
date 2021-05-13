package com.asylzhan.shop.JavaEE_midterm_shop.old_testing_servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ViewCartProductsServlet", value = "/ViewCartProductsServlet")
public class ViewCartProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Connection connection = ConnectDB.connect();

        String q;
//        PreparedStatement preparedStatement;
//        ResultSet rs;
        try {
            Cookie c = new Cookie(request.getParameter("id"), "1");
            c.setMaxAge(0);
            response.addCookie(c);
            pw.print("Product removed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pw.print("<a href='DisplayProductsServlet'>Go Back</a>");
        try {
            Cookie ck[] = request.getCookies();
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
            for(int i=0;i<ck.length; i++) {
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020"
                );
                q = "select * from products where id = " + ck[i].getName();
                PreparedStatement preparedStatement = connection.prepareStatement(q);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    pw.print("<tr><td>" + rs.getInt("id") + "</td>"
                            + "<td>" + rs.getString("name") + "</td>"
                            + "<td>" + rs.getDouble("price") + "</td>"
                            + "<td><a href='ViewCartProductsServlet?id=" + rs.getInt(1) + "'>Remove from cart</a></td>"
                            + "</tr><br><br>");
                }
            }
            pw.print("</table></body></html>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
