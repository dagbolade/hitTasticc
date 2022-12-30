<%-- 
    Document   : update
    Created on : 30 Dec 2022, 10:25:57
    Author     : dagbo
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "hittastic";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from user where id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<body>
<h1>Update User</h1>

 <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">Update User</div>
                <div class="card-body">
                    <form action="update-process.jsp" method="post">
                        <input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
                        <input type="text" name="id" value="<%=resultSet.getString("id") %>">
                        <div class =" form-group">
                            <label>name</label>
                            <input type="text" class="form-control" name="name" value="<%=resultSet.getString("name") %>" required>
                        </div>
                        <div class =" form-group">
                            <label>email</label>
                            <input type="email" class="form-control" name="email" value="<%=resultSet.getString("email") %>" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>