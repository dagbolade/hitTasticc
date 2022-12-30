<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%



Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>

<h1>Search Data</h1>
<table border="1">
<tr>
<td>title</td>
<td>artist</td>
<td>genre</td>


</tr>
<%
try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hittastic","root","");
           Statement st =conn.createStatement();
           
           //String title=request.getParameter("title");
           String artist=request.getParameter("artist"); //giving a null error exception
           
           String sql ="select * from songs where artist='"+artist+"'";
           resultSet = st.executeQuery(sql);
           while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("title") %></td>
<td><%=resultSet.getString("artist") %></td> 
<td><%=resultSet.getString("genre") %></td>


</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>