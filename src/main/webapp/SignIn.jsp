<%-- 
    Document   : SignIn
    Created on : 31 Dec 2022, 17:40:55
    Author     : dagbo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGN IN</title>
</head>
<body>
    <h1>Login</h1>
    <form action="SignIn" method="post">
        <label for="username">Email:</label><br>
        <input type="text" id="Email" name="username"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Submit">
    </form> 
</body>
</html>
