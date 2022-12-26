<%-- 
    Document   : order
    Created on : 20 Dec 2022, 23:08:05
    Author     : dagbo
--%>


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
        <h1>Hello World!</h1>
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>


