package com.asylzhan.shop.JavaEE_midterm_shop.old_testing_servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/product-list")
public class ProductTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>Testing products in DB</h1>");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from products");
            pw.println("<html><body>");
            while (resultSet.next()) {
                pw.println("<h4>Product name: " + resultSet.getString("name") + "</h4>");
                pw.println("<h4>Product price: " + resultSet.getString("price") + "</h4>");
                pw.println("<h4>Product color: " + resultSet.getString("color") + "/<h4><br>");
            }
            pw.println("<a href=\"index.jsp\">" + "Home page" + "</a>");
            pw.println("</body></html>");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
