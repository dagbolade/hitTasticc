<%-- 
    Document   : order
    Created on : 20 Dec 2022, 23:08:05
    Author     : dagbo
--%>


<%@page import="java.util.List"%>
<%@page import="com.assessment.hittasticc.dao.OrderDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.assessment.hittasticc.model.*"%>
<%@page import="com.assessment.hittasticc.connection.dbconn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% user auth =(user) request.getSession().getAttribute("auth");
//set it as a global variable
List<Order> orders = null;
   if (auth!=null){
        request.setAttribute("auth", auth);
        orders = new OrderDao(dbconn.getConnection()).userOrders(auth.getId());
    }else{
       response.sendRedirect("login.jsp");
       
   }
   
   //get the cart list from the session list
   ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
   if(cart_list != null){
       request.setAttribute("cart_list", cart_list);
   }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders</title>
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        
        <div class="container">
            <div class="card-header my-3">
                All Orders
            </div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Date</th>
                        <th scope="col">Artist</th>
                        <th scope="col">Title</th>
                        <th scope="col">Genre</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Remove</th>
                    </tr>
                </thead>
                <tbody
                    <% 
                        if(orders != null){
                           for(Order o:orders){%>
                           <tr>
                            <td><%= o.getDate()%></td>
                            <td><%= o.getArtist()%></td>
                            <td><%= o.getTitle()%></td>
                            <td><%= o.getGenre()%></td>
                            <td><%= o.getQty()%></td>
                            <td><%= o.getAmount()%></td>
                            <td><a class="btn btn-sm btn-danger" href="remove-order?id=<%= o.getOrderId()%> "> Remove </a></td>
                               
                            </tr>
                           <%} 
                        }
                    %>
                
            </tbody>
            </table>
        </div>
        
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>


