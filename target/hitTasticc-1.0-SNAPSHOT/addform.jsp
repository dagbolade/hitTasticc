<%-- 
    Document   : addform
    Created on : 29 Dec 2022, 20:00:08
    Author     : dagbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="addsong.jsp" method="post">
                Song Name:<input type="text" name="title"><br>
                Artist name:<input type="text" name="artist"><br>
                
                Genre:<input type="text" name="quantity"><br><br>
                <input type="submit" value="Submit">
                <p><a href ="http://localhost:8080/assessmentWeb/Adminpage.jsp">Back to Admin page</a></p>
            </form>
    </body>
</html>
