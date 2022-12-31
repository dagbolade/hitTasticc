<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.assessment.hittasticc.model.Song"%>
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
  // get search input value
  String searchInput = request.getParameter("q");

  ArrayList<Song> songs = new ArrayList<Song>();

  // send search input to database and get results
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hittastic", "root", "");
    String query = "SELECT * FROM songs WHERE artist LIKE ? OR title LIKE ?";
    pstmt = conn.prepareStatement(query);
    pstmt.setString(1, "%" + searchInput + "%");
    pstmt.setString(2, "%" + searchInput + "%");
    rs = pstmt.executeQuery();

    // add each result to the list of songs
    while (rs.next()) {
      Song song = new Song();
      song.setId(rs.getInt("id"));
      song.setTitle(rs.getString("title"));
      song.setArtist(rs.getString("artist"));
      song.setAmount(rs.getDouble("amount"));
      song.setGenre(rs.getString("genre"));
      songs.add(song);
    }
  } catch (SQLException se) {
    se.printStackTrace();
  } catch (Exception e) {
    e.printStackTrace();
  } finally {
    try {
      if (rs != null) rs.close();
      if (pstmt != null) pstmt.close();
      if (conn != null) conn.close();
    } catch (SQLException se) {
      se.printStackTrace();
    }
  }
  // store the list of songs in the request attribute
  request.setAttribute("songs", songs);
%>

<%@include file="/includes/header.jsp"%>
<div class="container my-5">
  <div class="card-header">
    Searched Results
  </div>
  <div class="row">
    <%
      // get the list of songs from the request attribute
     
      for (Song song : songs) {
    %>
    <div class="col-md-3 my-3">
      <div class="card w-100" style="width: 18rem;">
        <div class="card-body">
          <h5 class="card-title">Song Title: <%=song.getTitle()%> </h5>
          <h6 class="artistt">Artist : <%=song.getArtist()%></h6>
          <h7 class="amount">Amount : £<%=song.getAmount()%></h7>
          <h8 class="genre">Genre : <%=song.getGenre()%></h8>
          <div class="d-flex justify-content-between mt-3">
            <a href="add-to-cart?id=<%=song.getId()%>" class="btn btn-outline-success">Add to Cart</a>
            <a href="order-now?quantity=1&id=<%=song.getId()%>" class="btn btn-primary">Buy Song</a>
          </div>
        </div>
      </div>
    </div>
    <%
      }
%>
</div>
</div>
<%@include file="/includes/footer.jsp"%>