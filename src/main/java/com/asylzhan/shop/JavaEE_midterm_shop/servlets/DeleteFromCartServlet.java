package com.asylzhan.shop.JavaEE_midterm_shop.servlets;

import com.asylzhan.shop.JavaEE_midterm_shop.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteFromServlet",value = "/DeleteFromServlet")
public class DeleteFromCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        int index = isExisting(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
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
