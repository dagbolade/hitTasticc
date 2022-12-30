<%-- 
    Document   : addform
    Created on : 29 Dec 2022, 20:00:08
    Author     : dagbo
--%>

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
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">User Login</div>
                <div class="card-body">
                    <form action="addsong.jsp" method="post">
                        <div class =" form-group">
                            <label>Song Name</label>
                            <input type="text" class="form-control" name="title" placeholder="Enter title" required>
                        </div>
                        <div class =" form-group">
                            <label>Artist Name</label>
                            <input type="text" class="form-control" name="artist" placeholder="Enter artist name" required>
                        </div>
                        <div class =" form-group">
                            <label>Amount</label>
                            <input type="text" class="form-control" name="amount" placeholder="Enter an amount" required>
                        </div>
                        <div class =" form-group">
                            <label>Genre</label>
                            <input type="text" class="form-control" name="genre" placeholder="Enter genre" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary" value="submit">submit</button>
                        </div>
                        
                    </form>
                     <p><a href ="adminIndex.jsp">Back to Admin page</a></p>
                </div>
            </div>
        </div>
        
        
       
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>
