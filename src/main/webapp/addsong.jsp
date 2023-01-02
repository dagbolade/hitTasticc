<%-- 
    Document   : addsong
    Created on : 29 Dec 2022, 16:56:06
    Author     : dagbo
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.assessment.hittasticc.connection.dbconn"%>
<%@page import="com.assessment.hittasticc.dao.*"%>
<%@page import="com.assessment.hittasticc.model.Song"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Songs</title>
    </head>
    <body>
        <%@include file="/includes/adminnavbar.jsp"%>
        <h2>Songs added</h2>
        <br>
        <br>
        <%
    //Get the user input
    String title = request.getParameter("title");
    String artist = request.getParameter("artist");
    String amount = request.getParameter("amount");
    String genre = request.getParameter("genre");
    try
{
         Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hittastic","root","");
           Statement st=conn.createStatement();
           int i=st.executeUpdate("insert into songs(title,artist,amount,genre)values('"+title+"','"+artist+"','"+amount+"','"+genre+"')");
        out.println("Song has been successfully added");
        }
        catch(Exception e)
        {
        System.out.print(e);
        e.printStackTrace();
        }
    

%>

            
                <p><a href ="adminIndex.jsp">Back to Admin page</a></p>
           <%@include file="/includes/footer.jsp"%>
    </body>
</html>

<!DOCTYPE html>