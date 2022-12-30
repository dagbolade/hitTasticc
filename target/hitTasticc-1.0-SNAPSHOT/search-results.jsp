<%@page import="com.assessment.hittasticc.model.user"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%



Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;

user auth = (user) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }

%>
<!DOCTYPE html>
<html>
<head>
        <%@include file="/includes/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Searched Results</title>
    </head>
    
    <body> 
        <%@include file="/includes/navbar.jsp"%>
        


<%
try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hittastic","root","");
           Statement st =conn.createStatement();
           
           String title=request.getParameter("title");
           String artist=request.getParameter("artist"); //giving a null error exception
           
           String sql ="select * from songs where artist='"+artist+"' OR title='"+title+"'";
           resultSet = st.executeQuery(sql);
           while(resultSet.next()){
%>
<div class="container">
    <div class="card-header my-3">
                Searched Results
            </div>
                  <div class="row">   
                    <div class="col-md-3 my-3">
                            <div class="card w-100" style="width: 18rem;">
                             <div class="card-body">
                                 <h5 class="card-title">Song Title: <%=resultSet.getString("title") %> </h5>
                                 <h6 class="artistt">Artist : <%=resultSet.getString("artist") %></h6>
                                 <h7 class="amount">Amount : £<%=resultSet.getString("amount") %></h7>
                                 <h8 class="genre">Genre : <%=resultSet.getString("genre") %></h8>
                            <div class="d-flex justify-content-between mt-3">
                                <a href="add-to-cart?id=<%=resultSet.getString("id") %>" class="btn btn-outline-success">Add to Cart</a>
                                <a href="order-now?quantity=1&id=<%=resultSet.getString("id") %>" class="btn btn-primary">Buy Song</a>
                            </div>
                           
                        </div>
                    </div>
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
<%@include file="/includes/footer.jsp"%>
</body>
</html>