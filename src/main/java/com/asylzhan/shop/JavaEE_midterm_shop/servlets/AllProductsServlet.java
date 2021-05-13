package com.asylzhan.shop.JavaEE_midterm_shop.servlets;

import com.asylzhan.shop.JavaEE_midterm_shop.dao.ProductDAO;
import com.asylzhan.shop.JavaEE_midterm_shop.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllProductsServlet", value = "/AllProductsServlet")
public class AllProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();

        List<Product> productList = productDAO.selectAllProducts();
        request.setAttribute("productList", productList);

        request.getRequestDispatcher("products.jsp").forward(request,response);
    }
}
