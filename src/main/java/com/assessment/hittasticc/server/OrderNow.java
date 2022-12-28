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

            user auth = (user) request.getSession().getAttribute("auth");
            if (auth != null) {
                String songid = request.getParameter("id");
                int songQty = Integer.parseInt(request.getParameter("quantity"));
                if (songQty <= 0) {
                    songQty = 1;
                }
                Order order = new Order();
                order.setId(Integer.parseInt(songid));
                order.setUid(auth.getId());
                order.setQty(songQty);

                OrderDao orderDao = new OrderDao(dbconn.getConnection());
                boolean result = orderDao.insertOrder(order);

                if (result) {
                    ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
                    if (cart_list != null) {
                        for (Cart c : cart_list) {
                            if (c.getId() == Integer.parseInt(songid)) {
                                cart_list.remove(cart_list.indexOf(c));
                                break;
                            }
                        }
                    }
                    response.sendRedirect("order.jsp");
                } else {
                    out.println("order failed");
                }

            } else {
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
