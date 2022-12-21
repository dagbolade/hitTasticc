<%-- 
    Document   : index
    Created on : 20 Dec 2022, 17:09:29
    Author     : dagbo
--%>

<%@page import="com.assessment.hittasticc.model.*"%>
<%@page import="com.assessment.hittasticc.connection.dbconn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% user auth = (user) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Welcome to HitTastic</title>
    </head>
    <body> 
        <%@include file="/includes/navbar.jsp"%>
        <% out.print(dbconn.getConnection());%>


        <div class ="card-body mx-auto my-5 ">
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search for music" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>

        <div class="container">
            <div class="card-header my-3">
                ALL SONGS
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div class="card w-150" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Song Title: FIA </h5>
                            <h6 class="artistt">Artist : Davido</h6>
                            <h7 class="amount">Amount : £30</h7>
                            <div class="mt-3 d-flex justify-content-between">
                                <a href="#" class="btn btn-primary">Add to Cart</a>
                                <a href="#" class="btn btn-primary">Buy Song</a>
                            </div>
                           
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>
