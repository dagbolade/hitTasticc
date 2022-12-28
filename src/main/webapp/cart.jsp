<%-- 
    Document   : cart
    Created on : 20 Dec 2022, 17:19:11
    Author     : dagbo
--%>

<%@page import="com.assessment.hittasticc.dao.SongsDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.assessment.hittasticc.model.*"%>
<%@page import="com.assessment.hittasticc.connection.dbconn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% user auth =(user) request.getSession().getAttribute("auth");
   if (auth!=null){
        request.setAttribute("auth", auth);
    }
   //get the cart list from the session list
   ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
   List<Cart> cartSong = null;
   if(cart_list != null){
       SongsDao s = new SongsDao(dbconn.getConnection());
       cartSong = s.getCartSongs(cart_list);
       double sum = s.getTotalAmount(cart_list);
       request.setAttribute("cart_list", cart_list);
       request.setAttribute("sum", sum);
   }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User cart</title>
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        <div class="container">
            
               <%--create a table to display all the cart songs--%>
               <table class="table table-light">
                   <thead>
                       <tr>
                           <th scope="col">Artist</th>
                           <th scope="col">Title</th>
                           <th scope="col">Amount</th>
                           <th scope="col">Quantity</th>
                           <th scope="col">Cancel</th>
                       </tr>
                   </thead>
                   <tbody>
                       <% if(cart_list != null){
                            for(Cart c:cartSong){%>
                                <tr>
                           <td> <%= c.getArtist()%></td>
                           <td><%= c.getTitle() %></td>
                           <td>£<%= c.getAmount() %></td>
                           <td>
                               <form action="order-now" method="post" class="form-inline">
                                   <%--put the songs id in a form--%>
                                   <input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
                                   <div class="form-group d-flex justify-content-between w-50">
                                       <a class="btn btn-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%= c.getId() %>"><i class="fas fa-plus-square"></i></a>
                                       <input type="number" name="quantity" class="form-control w-50"  value="<%= c.getQuantity() %>" readonly>
                                       <a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%= c.getId() %>"><i class="fas fa-minus-square"></i></a>
                                   </div>
                                   <button type="submit" class="btn btn-primary btn-sm">Buy Now</button>
                               </form>
                           </td>
                           <<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%= c.getId() %>">Cancel</a></td>
                       </tr>
                       <%}
                       } 
                       %>
                       
                   </tbody>
               </table>
            <div class="d-flex py-3">
               <h3> Total Amount : £ ${(sum>0)? sum:0 } </h3><a class="mx-3 btn btn-primary" href="check-out">Check Out</a>
               </div>
        </div>
        
        
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>


