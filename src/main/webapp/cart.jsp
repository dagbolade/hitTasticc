<%-- 
    Document   : cart
    Created on : 20 Dec 2022, 17:19:11
    Author     : dagbo
--%>

<%@page import="com.assessment.hittasticc.model.*"%>
<%@page import="com.assessment.hittasticc.connection.dbconn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% user auth =(user) request.getSession().getAttribute("auth");
   if (auth!=null){
        request.setAttribute("auth", auth);
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
        <h1>Hello World!</h1>
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>
