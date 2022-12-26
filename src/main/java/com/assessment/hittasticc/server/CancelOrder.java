/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.server;

import com.assessment.hittasticc.model.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dagbo
 */
@WebServlet(name = "CancelOrder", urlPatterns = {"/cancel-order"})
public class CancelOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Set the content type of the response to "text/html;charset=UTF-8"
        response.setContentType("text/html;charset=UTF-8");
        // Obtain a PrintWriter object to write the response
        try (PrintWriter out = response.getWriter()) {
             // Get the value of the "id" parameter from the request
            String id = request.getParameter("id");
             // Check if the "id" parameter has a value
            if (id != null) {
                // Get the cart-list from the session
                ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
                // Check if the cart-list exists
                if (cart_list != null) {
                     // Iterate through the cart-list
                    for (Cart c : cart_list) {
                         // If a Cart object with the matching id is found, remove it from the list
                        if (c.getId() == Integer.parseInt(id)) {
                            cart_list.remove(cart_list.indexOf(c));
                            break;
                        }
                    }
                      // Redirect the user to the "cart.jsp" page
                    response.sendRedirect("cart.jsp");
                }
            } else {
                // If the "id" parameter is null, simply redirect the user to the "cart.jsp" page
                response.sendRedirect("cart.jsp");
            }
        }
    }

}
