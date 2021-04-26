package com.asylzhan.shop.JavaEE_midterm_shop;

import com.asylzhan.shop.JavaEE_midterm_shop.dao.UserDao;
import com.asylzhan.shop.JavaEE_midterm_shop.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDescriptionServlet", value = "/ProductDescriptionServlet")
public class ProductDescriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String protuctId = request.getParameter("productId");
        List<?> comments = null;
        Product product = new Product();

        if(protuctId != null && !(protuctId.equals(""))){
            try {
                product = new UserDao().selectOne(Integer.parseInt(protuctId));
                comments = new UserDao().selectComments(product.getId());
            } catch (Exception e) {
                request.getSession().setAttribute("exception",e.getMessage());
            }
            request.getSession().setAttribute("product", product);
            request.getSession().setAttribute("comments",comments);
            response.sendRedirect("product-description.jsp");
        }else{
            request.getSession().setAttribute("message", "Error !!!! Please select one Category!!!!!!");
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
