<%@page import="model.GenreDAO"%>
<%@page import="java.util.List"%>
<%@page import="entity.Genre"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Administration Manager | For Administrator Only</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="css/style.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <jsp:include page="Header.jsp"></jsp:include>
    <!-- NAVIGATION -->
    <nav id="navigation">
	<!-- container -->
	<div class="container">
	    <!-- responsive-nav -->
	    <div id="responsive-nav">
		<!-- NAV -->
		<ul class="main-nav nav navbar-nav">
		    <li><a href="hompage">Home</a></li>
		    <li class="active"><a href="">Add new Book</a></li>
                    <li><a href="manage">Delete/Edit Books</a></li>
		</ul>
	        <!-- /NAV -->
	    </div>
	    <!-- /responsive-nav -->
	</div>
	<!-- /container -->
    </nav>
    <!-- /NAVIGATION -->

	<!-- BREADCRUMB -->
	<div id="breadcrumb" class="section">
	    <!-- container -->
	    <div class="container">
		<!-- row -->
		<div class="row">
		    <div class="col-md-12">
			<ul class="breadcrumb-tree">
			    <li><a href="hompage">Home</a></li>
                            <li>Add</li>
			</ul>
		    </div>
		</div>
		<!-- /row -->
	    </div>
	    <!-- /container -->
        </div>
	<!-- /BREADCRUMB -->
        
        <!-- SecTION -->
        <div class="section">
	    <!-- container -->
	    <div class="container">
	        <!-- row -->
                
		<div class="row">
		    <!-- Product details -->
		    <div class="col-md-5">
		        <div class="product-details">
                            <form action="add" method="post">
                                <h6 style="color: red" style="font-size: small" >${mes}</h6>
                                ID:
                                <p>
                                    <input type="text" name="id" placeholder="Enter Book ID">
                                </p>
                                Name:
                                <p>
                                    <input type="text" name="name" placeholder="Enter Book Name">
                                </p>
                                AuthorID:
                                <p>
                                    <input type="text" name="author" placeholder="Enter Author ID">
                                    <input type="text" name="authorname" placeholder="Name (New Only)">
                                    is New
                                    <input type="checkbox" name="newauthor">
                                </p>
                                Description:
                                <p>
                                    <textarea rows="10" cols="50" name="description">Enter Description ...</textarea>
                                </p>
                                Genre:
                                <p> 
                                    <%
                                        GenreDAO gdao = new GenreDAO();
                                        List<Genre> list = gdao.getAllGenre();
                                    %>
                                    <%
                                        for (Genre g : list) {
                                    %>
                                    <div class="input-checkbox">
                                        <input type="checkbox" name="checkCate" id="<%=g.getGenreId()%>" value="<%=g.getGenreId()%>">
				            <label for="<%=g.getGenreId()%>">
				            <span></span>
				            <%=g.getName()%>
		                        </label>
                                    </div>
                                    <% } %>
                                    
                                </p>
                                Price:
                                <p>
                                    <input type="text" name="price"">
                                </p>
                                <p>
                                    <input type="submit" value="Add Book">
                                    <h6 style="color: red" style="font-size: small" >${mess}</h6>
                                </p>   
                            </form>
			</div>
		    </div>
		    <!-- /Product details -->
		</div>
		<!-- /row -->
	    </div>
	    <!-- /container -->
	</div>
	<!-- /SECTION -->     
        <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
