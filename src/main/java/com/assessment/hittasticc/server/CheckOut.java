/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.server;

import com.assessment.hittasticc.connection.dbconn;
import com.assessment.hittasticc.dao.OrderDao;
import com.assessment.hittasticc.model.Cart;
import com.assessment.hittasticc.model.Order;
import com.assessment.hittasticc.model.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dagbo
 */
@WebServlet(name = "CheckOut", urlPatterns = {"/check-out"})
public class CheckOut extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            
            //get the cart-list from the esession
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            // Get the "auth" attribute from the session to make sure user logs in before they checkout
            user auth = (user) request.getSession().getAttribute("auth");
            if (auth != null && cart_list != null) {
                for(Cart c:cart_list){
                    Order song = new Order();
                    song.setId(c.getId());
                    song.setUid(auth.getId());
                    song.setQty(c.getQuantity());
                    song.setDate(formatter.format(date));
                    
                    //instantiate the Dao class
                    OrderDao music = new OrderDao(dbconn.getConnection());
                    //called the insert method
                    boolean result = music.insertOrder(song);
                    if(!result) break;
                    
                }
                
                cart_list.clear();
                response.sendRedirect("order.jsp");
                
            }else{
                if(auth == null) response.sendRedirect("login.jsp");
                response.sendRedirect("cart.jsp");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    

}
