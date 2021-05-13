package com.asylzhan.shop.JavaEE_midterm_shop.servlets;

import com.asylzhan.shop.JavaEE_midterm_shop.dao.ProductDAO;
import com.asylzhan.shop.JavaEE_midterm_shop.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public CartServlet(){}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        HttpSession session = request.getSession();
        if (request.getParameter("product_id") == null){
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        }

        Integer product_id = Integer.parseInt(request.getParameter("product_id"));


        if (session.getAttribute("cart") == null) {
            List<Cart> cart = new ArrayList<>();
            cart.add(new Cart(productDAO.selectProduct(product_id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<Cart> cart = (List<Cart>) session.getAttribute("cart");

            int index = isExisting(product_id, cart);
            if (index == -1) {
                cart.add(new Cart(productDAO.selectProduct(product_id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        request.getRequestDispatcher("cart.jsp").forward(request,response);
    }

    private int isExisting(int id, List<Cart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            int id2 = cart.get(i).getProduct().getId();
            if (id2 == id) {
                return i;
            }
        }
        return -1;
    }
}
