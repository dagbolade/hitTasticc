<%-- 
    Document   : navbar
    Created on : 20 Dec 2022, 23:59:32
    Author     : dagbo
--%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="home.jsp">HitTastic</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="home.jsp">Home </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cart.jsp">Cart<span class="badge badge-primary px-2">${ cart_list.size()}</span></a>
                </li>
                <form action="search-results.jsp" method="post" class="form-inline my-2 my-lg-0">
                        <input type="search" class="form-control mr-sm-2" name="q" id="search-input" placeholder="Search for artist or title" >
                        
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="save">Search</button>
                    </form>


                <%if (auth != null) {%>
                <li class="nav-item">
                    <a class="nav-link disabled" href="order.jsp">Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="Logout">Logout</a>
                </li>
                
                <%} else {%>
                <li class="nav-item">
                    <a class="nav-link disabled" href="login.jsp">Login</a>
                </li>
                
                    
               
                <%}
                %>




            </ul>

        </div>
    </div>

</nav>