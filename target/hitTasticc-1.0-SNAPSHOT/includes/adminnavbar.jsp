<%-- 
    Document   : adminnavbar
    Created on : 29 Dec 2022, 12:24:29
    Author     : dagbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">HitTastic</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="adminIndex.jsp">Home </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewUsers.jsp">view users<span class="badge badge-primary px-2">${ cart_list.size()}</span></a>
                </li>
                


                
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Manage User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="addform.jsp">Add Song</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Logout</a>
                </li>
                
                    
               
       



            </ul>

        </div>
    </div>

</nav>