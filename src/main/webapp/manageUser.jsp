<%-- 
    Document   : manageUser
    Created on : 30 Dec 2022, 09:53:56
    Author     : dagbo
--%>

<%@page import="com.assessment.hittasticc.dao.adminDao"%>
<%@page import="com.assessment.hittasticc.connection.dbconn"%>
<%@page import="com.assessment.hittasticc.model.user"%>
<%@page import="java.util.List"%>
<%@page import="com.assessment.hittasticc.model.admlgn"%>
<% admlgn auth =(admlgn) request.getSession().getAttribute("auth");
List<user> users = null;
   if (auth!=null){
        request.setAttribute("auth", auth);
        users = new adminDao(dbconn.getConnection()).viewUsers();
    }else{
       response.sendRedirect("admlogin.jsp");
       
   }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/includes/adminnavbar.jsp"%>
        
        
        <div class="container">
            <div class="card-header my-3">
                All Users
            </div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">name</th>
                        <th scope="col">email</th>
                        
                    </tr>
                </thead>
                <tbody
                    <% 
                        if(users != null){
                           for(user u:users){%>
                           <tr>
                            <td><%= u.getId()%></td>
                            <td><%= u.getName()%></td>
                            <td><%= u.getEmail()%></td>
                            <td><a class="btn btn-sm btn-danger" href="remove-user?id=<%= u.getId()%> "> Remove </a></td>
                            
                               
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
