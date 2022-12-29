<%-- 
    Document   : admlogin
    Created on : 29 Dec 2022, 11:34:33
    Author     : dagbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.assessment.hittasticc.model.admlgn"%>
<% admlgn auth =(admlgn) request.getSession().getAttribute("auth");
   if (auth!=null){
        //if auth is null login would be visible
        response.sendRedirect("adminIndex.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">Admin Login</div>
                <div class="card-body">
                    <form action="admin-login" method="post">
                        <div class =" form-group">
                            <label>Email Address</label>
                            <input type="email" class="form-control" name="login-email" placeholder="Enter your email" required>
                        </div>
                        <div class =" form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="login-password" placeholder="Enter your password" required>
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
