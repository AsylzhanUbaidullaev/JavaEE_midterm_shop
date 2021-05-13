package com.asylzhan.shop.JavaEE_midterm_shop.servlets;

import com.asylzhan.shop.JavaEE_midterm_shop.dao.ProductDAO;
import com.asylzhan.shop.JavaEE_midterm_shop.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDetailServlet", value = "/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();

        int productId = 0;

        if(request.getParameter("productId") != null) {
            productId = Integer.parseInt(request.getParameter("productId"));
        }
        Product product = productDAO.selectProduct(productId);

        request.setAttribute("product", product);

        request.getRequestDispatcher("product-description.jsp").forward(request,response);
    }
}
