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
        <div class="container">
            
               <%--create a table to display all the cart songs--%>
               <table class="table table-light">
                   <thead>
                       <tr>
                           <th scope="col">Artist</th>
                           <th scope="col">Title</th>
                           <th scope="col">Amount</th>
                           <th scope="col">Buy Now</th>
                           <th scope="col">Cancel</th>
                       </tr>
                   </thead>
                   <tbody>
                       <tr>
                           <td>Davido</td>
                           <td>FIA</td>
                           <td>30</td>
                           <td>
                               <form action="" method="post" class="form-inline">
                                   <%--put the songs id in a form--%>
                                   <input type="hidden" name="id" value="1" class="form-input">
                                   <div class="form-group d-flex justify-content-between">
                                       <a class="btn btn-sm btn-incre" href="#"><i class="fas fa-plus-square"></i></a>
                                       <input type="text" name="quantity" class="form-control" value="1" readonly>
                                       <a class="btn btn-sm btn-decre" href="#"><i class="fas fa-minus-square"></i></a>
                                   </div>
                               </form>
                           </td>
                           <<td><a class="btn btn-sm btn-danger" href="">Cancel</a></td>
                       </tr>
                   </tbody>
               </table>
            <div class="d-flex py-3">
               <h3> Total Amount : £534 </h3><a class="mx-3 btn btn-primary" href="#">Check Out</a>
               </div>
        </div>
        
        
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>
