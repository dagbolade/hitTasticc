<%-- 
    Document   : update-process
    Created on : 30 Dec 2022, 10:39:18
    Author     : dagbo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.cj.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/hittastic";%>
<%!String user = "root";%>
<%!String psw = "";%>
<%

String id = request.getParameter("id");
String name=request.getParameter("name");
String email=request.getParameter("email");

if(id != null)
{
int personID = Integer.parseInt(id);
Connection con = null;
PreparedStatement ps = null;

try
{
    
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="update user set id=?, name=?,email=? where id="+id;

ps = con.prepareStatement(sql);
ps.setString(1, id);
ps.setString(2, name);
ps.setString(3, email);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
} 
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}

%>