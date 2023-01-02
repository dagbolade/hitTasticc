<%-- 
    Document   : SignIn
    Created on : 31 Dec 2022, 17:40:55
    Author     : dagbo
--%>


<%-- 
    Document   : login
    Created on : 20 Dec 2022, 17:18:57
    Author     : dagbo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.assessment.hittasticc.model.Cart"%>
<%@page import="com.assessment.hittasticc.model.user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% user auth =(user) request.getSession().getAttribute("auth");
   if (auth!=null){
        //if auth is null login would be visible
        response.sendRedirect("home.jsp");
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
        <title>Login</title>
    </head>
    <body>
        
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">Login</div>
                <div class="card-body">
                    <form action="SignIn" method="post">
                        <div class =" form-group">
                            <label>Email Address</label>
                            <input type="email" class="form-control" name="email" placeholder="Enter your email" required>
                        </div>
                        <div class =" form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="password" placeholder="Enter your password" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>



