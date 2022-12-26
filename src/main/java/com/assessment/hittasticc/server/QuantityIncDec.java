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
@WebServlet(name = "QuantityIncDec", urlPatterns = {"/quantity-inc-dec"})
public class QuantityIncDec extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter();){
             // Get the 'action' and 'id' parameters from the request
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            
            // Get the 'cart-list' attribute from the session
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            
            // Check if the 'action' and 'id' variables are not null and if the 'id' variable is greater than or equal to 1 
            if(action != null && id >= 1){
                // Check if the 'action' variable is equal to 'inc'
                if(action .equals("inc")){
                     // Iterate over the 'cart-list' and find the Cart object with a matching 'id'
                    for(Cart c:cart_list){
                        if(c.getId() == id){
                            // Increment the 'quantity' field of the Cart object
                            int quantity = c.getQuantity();
                            quantity++;
                            c.setQuantity(quantity);
                            
                            // Redirect the client to the 'cart.jsp' page
                            response.sendRedirect("cart.jsp");
                        }
                    }
                }
                
                 // Check if the 'action' variable is equal to 'dec'
                if(action .equals("dec")){
                     // Iterate over the 'cart-list' and find the Cart object with a matching 'id'
                    for(Cart c:cart_list){
                        if(c.getId() == id && c.getQuantity() >1){
                            // Decrement the 'quantity' field of the Cart object
                            int quantity = c.getQuantity();
                            quantity--;
                            c.setQuantity(quantity);
                            break;
                            
                        }
                    }
                    // Redirect the client to the 'cart.jsp' page
                    response.sendRedirect("cart.jsp");
                }
            }else{
                response.sendRedirect("cart.jsp");
            }
        }
    }


}
