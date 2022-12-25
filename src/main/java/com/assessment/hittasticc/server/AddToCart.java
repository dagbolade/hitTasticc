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
import javax.servlet.http.HttpSession;

/**
 *
 * @author dagbo
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/add-to-cart"})
public class AddToCart extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()){
            //initialize the arraylist as an object which is cart
            ArrayList<Cart> cartList = new ArrayList<>();
            
            //get the id of the songs
            int id =Integer.parseInt(request.getParameter("id"));
            Cart item = new Cart();
            item.setId(id);
            item.setQuantity(1);
            
            //Gets the current session for the request.
            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
            
            //Gets the attribute called "cart-list" from the session, which should be an ArrayList of Cart objects.
            if(cart_list == null) {
                cartList.add(item);
                session.setAttribute("cart-list", cartList);
                //out.println("session created and added the list");
                response.sendRedirect("index.jsp");
            }else {
                // check if its exist
                cartList = cart_list;
                //check if the song alrealfy exists in the cart or not
                boolean exist = false;
                
                for(Cart c:cartList){
                    if(c.getId() == id) {
                        exist = true;
                        out.println("Song already exists in Cart. <a href = 'cart.jsp'>GO to cart</a>");
                    } 
                }
                if(!exist){
                        cartList.add(item);
                        response.sendRedirect("index.jsp");
                }
            }
            
        }
    }

    

}
