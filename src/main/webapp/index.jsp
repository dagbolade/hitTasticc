<%-- 
    Document   : index
    Created on : 20 Dec 2022, 17:09:29
    Author     : dagbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Welcome to HitTastic</title>
    </head>
    <body>
       <%@include file="/includes/navbar.jsp"%>
       <div class ="card-body mx-auto my-5">
         <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search for music" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
       </div>
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>
