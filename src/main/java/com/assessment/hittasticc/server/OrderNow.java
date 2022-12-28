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
import java.sql.SQLException;
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
@WebServlet(name = "OrderNow", urlPatterns = {"/order-now"})
public class OrderNow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            
            // Get the "auth" attribute from the session
            user auth = (user) request.getSession().getAttribute("auth");
            if (auth != null) {
                // Get the "id" parameter from the request
                String songid = request.getParameter("id");
                // Get the "id" parameter from the request
                int songQty = Integer.parseInt(request.getParameter("quantity"));
                
    // If the value of "songQty" is less than or equal to 0, set it to 1
    // This is done to ensure that the user is ordering at least one song
                if (songQty <= 0) {
                    songQty = 1;
                }
                // Create an "Order" object and set its properties using the values of "songid", "auth.getId()", and "songQty"
                
                Order order = new Order();
                order.setId(Integer.parseInt(songid));
                order.setUid(auth.getId());
                order.setQty(songQty);
                
                
    // Create an "OrderDao" object and call the "insertOrder" method, passing in the "order" object as an argument
                OrderDao orderDao = new OrderDao(dbconn.getConnection());
                boolean result = orderDao.insertOrder(order);

                if (result) {
                     // If the "insertOrder" method returns true, it means that the order was successfully inserted into the database
        // Get the "cart-list" attribute from the session and remove the song with the same ID as the one that was just ordered
                    ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
                    if (cart_list != null) {
                        for (Cart c : cart_list) {
                            if (c.getId() == Integer.parseInt(songid)) {
                                cart_list.remove(cart_list.indexOf(c));
                                break;
                            }
                        }
                    }
                    // Redirect the user to the "order.jsp" page
                    response.sendRedirect("order.jsp");
                } else {
                   // If the "insertOrder" method returns false, it means that the order was not successfully inserted into the database
        // Print a message saying that the order failed
                    out.println("order failed");
                }

            } else {
                // If the "auth" variable is null, it means that the user is not authenticated
    // Redirect the user to the "login.jsp" page
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
