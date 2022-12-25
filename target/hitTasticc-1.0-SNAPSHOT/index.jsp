<%-- 
    Document   : index
    Created on : 20 Dec 2022, 17:09:29
    Author     : dagbo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.assessment.hittasticc.dao.SongsDao"%>
<%@page import="com.assessment.hittasticc.model.*"%>
<%@page import="com.assessment.hittasticc.connection.dbconn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% user auth = (user) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
    
SongsDao song = new SongsDao(dbconn.getConnection());
List<Song> allsongs = song.getAllSongs();
//get the cart list from the session list
   ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
   if(cart_list != null){
       request.setAttribute("cart_list", cart_list);
   }

%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Welcome to HitTastic</title>
    </head>
    <body> 
        <%@include file="/includes/navbar.jsp"%>
        
        <div class="container">
            <div class="card-header my-3">
                ALL SONGS
            </div>
            <div class="row">
                <%
                    if(!allsongs.isEmpty()){
                        for(Song s:allsongs){%>
                        <div class="col-md-3 my-3">
                            <div class="card w-100" style="width: 18rem;">
                             <div class="card-body">
                                 <h5 class="card-title">Song Title: <%= s.getTitle()%> </h5>
                                 <h6 class="artistt">Artist : <%=s.getArtist()%></h6>
                                 <h7 class="amount">Amount : £<%=s.getAmount()%></h7>
                                 <h8 class="genre">Genre : <%=s.getGenre()%></h8>
                            <div class="d-flex justify-content-between mt-3">
                                <a href="add-to-cart?id=<%= s.getId() %>" class="btn btn-outline-success">Add to Cart</a>
                                <a href="#" class="btn btn-primary">Buy Song</a>
                            </div>
                           
                        </div>
                    </div>
                </div>
                        
                        <%}
                    }
                %>
                 
              

            </div>

        </div>
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>
