<%-- 
    Document   : search-results
    Created on : 28 Dec 2022, 16:47:04
    Author     : dagbo
--%>

<%@page import="java.lang.String"%>
<%@page import="java.util.List"%>
<%@page import="com.assessment.hittasticc.model.Song"%>
<%@page import="com.assessment.hittasticc.dao.SongsDao"%>
<%@page import="com.assessment.hittasticc.connection.dbconn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
SongsDao song = new SongsDao(dbconn.getConnection());
String title = request.getParameter("songList");
List<Song> songList = song.searchMusic(title);
System.out.println("Song list: " + songList);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Search Results</h1>
   <div class="container">
            <div class="card-header my-3">
                ALL SONGS
                <%System.out.println("Number of songs found: " + songList.size());%>
            </div>
            <div class="row">
                <%
                    if(!songList.isEmpty()){
                        for(Song s:songList){%>
                        <div class="col-md-3 my-3">
                            <div class="card w-100" style="width: 18rem;">
                             <div class="card-body">
                                 <h5 class="card-title">Song Title: <%= s.getTitle()%> </h5>
                                 <h6 class="artistt">Artist : <%=s.getArtist()%></h6>
                                 <h7 class="amount">Amount : £<%=s.getAmount()%></h7>
                                 <h8 class="genre">Genre : <%=s.getGenre()%></h8>
                            <div class="d-flex justify-content-between mt-3">
                                <a href="add-to-cart?id=<%= s.getId() %>" class="btn btn-outline-success">Add to Cart</a>
                                <a href="order-now?quantity=1&id=<%= s.getId()%>" class="btn btn-primary">Buy Song</a>
                            </div>
                           
                        </div>
                    </div>
                </div>
                <%}
                    }else{%>
                <div class="col-md-12 text-center">
                    <p>No songs found</p>
                </div>
                <%}%>
            </div>
        </div>
    </body>
</html>
