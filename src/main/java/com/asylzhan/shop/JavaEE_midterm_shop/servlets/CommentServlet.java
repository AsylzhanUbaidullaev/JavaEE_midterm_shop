package com.asylzhan.shop.JavaEE_midterm_shop.servlets;

import com.asylzhan.shop.JavaEE_midterm_shop.dao.ProductDAO;
import com.asylzhan.shop.JavaEE_midterm_shop.dao.UserDao;
import com.asylzhan.shop.JavaEE_midterm_shop.model.Comment;
import com.asylzhan.shop.JavaEE_midterm_shop.model.Product;
import com.asylzhan.shop.JavaEE_midterm_shop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CommentServlet", value = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        ProductDAO productDAO = new ProductDAO();

        int product_id = Integer.parseInt(request.getParameter("product_id"));
        int userid = Integer.parseInt(request.getParameter("userId"));
        String newComment = request.getParameter("comment");
        try {
            User user = userDao.selectById(userid);

            Comment comment = new Comment();
            comment.setComment(newComment);
            comment.setUserid(userid);
            comment.setProduct_id(product_id);
            comment.setUser(user);

            int r = 0;
            if (comment != null){
                r = productDAO.addComment(comment);
            }

            Product product = productDAO.selectProduct(product_id);
            request.setAttribute("product", product);

            System.out.println(r);
            request.getRequestDispatcher("product-description.jsp").forward(request,response);

        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
    }

}
