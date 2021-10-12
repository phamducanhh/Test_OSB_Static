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
		    <li><a href="">Add new Book</a></li>
                    <li class="active"><a href="">Delete/Edit Books</a></li>
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
                            <li><a href="manage">Edit</a></li>
			    <li class="active">${book.getId()}</li>
			</ul>
		    </div>
		</div>
		<!-- /row -->
	    </div>
	    <!-- /container -->
        </div>
	<!-- /BREADCRUMB -->

	<!-- SECTION -->
	<div class="section">
	    <!-- container -->
	    <div class="container">
	        <!-- row -->
		<div class="row">
		    <!-- Product main img -->
		    <div class="col-md-5 col-md-push-2">
			<div id="product-main-img">
			    <div class="product-preview">
				<img src="${book.getImage()}" alt="">
			    </div>

			    <div class="product-preview">
				<img src="${book.getImage1()}" alt="">
			    </div>

			    <div class="product-preview">
				<img src="${book.getImage2()}" alt="">
			    </div>

			    <div class="product-preview">
				<img src="${book.getImage3()}" alt="">
			    </div>
			</div>
		    </div>
		    <!-- /Product main img -->

		    <!-- Product thumb imgs -->
		    <div class="col-md-2  col-md-pull-5">
			<div id="product-imgs">
			    <div class="product-preview">
				<img src="${book.getImage()}" alt="">
			    </div>

			    <div class="product-preview">
				<img src="${book.getImage1()}" alt="">
			    </div>

			    <div class="product-preview">
				<img src="${book.getImage2()}" alt="">
			    </div>

			    <div class="product-preview">
				<img src="${book.getImage3()}" alt="">
			    </div>
			</div>
		    </div>
		    <!-- /Product thumb imgs -->

		    <!-- Product details -->
		    <div class="col-md-5">
		        <div class="product-details">
                            <form action="edit?id=${book.getId()}" method="post">
                                ID:
                                <p>
                                    <input type="text" name="bid" value="${book.getId()}" readonly>
                                </p>
                                Name:
                                <p>
                                    <input type="text" name="name" value="${book.getName()}">
                                </p>
                                AuthorID:
                                <p>
                                    <input type="text" name="author" value="${book.getAuthorId()}">
                                    <input type="text" name="authorname" value="" placeholder="Name (New Only)">
                                    is New
                                    <input type="checkbox" name="newauthor">
                                </p>
                                Description:
                                <p>
                                    <textarea rows="10" cols="50" name="description">${book.getDescription()}</textarea>
                                </p>
                                Genre:
                                <p> 
                                    <%
                                        List<Genre> lst = (List<Genre>) request.getAttribute("listGenreDetail");
                                        List<Genre> list = (List<Genre>) request.getAttribute("listGenre");
                                    %>
                                    <%
                                        for (Genre g : list) {
                                    %>
                                    <div class="input-checkbox">
                                        <input type="checkbox" name="checkCate" id="<%=g.getGenreId()%>" value="<%=g.getGenreId()%>" <%=g.isIn(lst)?"checked":""%>>
				            <label for="<%=g.getGenreId()%>">
				            <span></span>
				            <%=g.getName()%>
		                        </label>
                                    </div>
                                    <% } %>
                                    
                                </p>
                                Price:
                                <p>
                                    <input type="text" name="price" value="${book.getPrice()}">
                                </p>
                                <p>
                                    <input type="submit" value="Edit">
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
    <!-- jQuery Plugins -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/nouislider.min.js"></script>
    <script src="js/jquery.zoom.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
