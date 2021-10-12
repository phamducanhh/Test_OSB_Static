<%@page import="entity.User"%>
<%@page import="entity.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.OrderLineDAO"%>
<%@page import="entity.Book"%>
<%@page import="entity.OrderLine"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>A book a day | Give the stress away</title>

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
    <%
        String url = (String) request.getAttribute("url");
        User user = new User();
        String name="Anonymous";
        if((User) session.getAttribute("user")!=null) {
            user=(User) session.getAttribute("user");
            name=user.getUsername();
        }
        List<Review> list = (List<Review>)request.getAttribute("listReview");        
    %>
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
                    <c:forEach items="${listGenre}" var="genre">
                        <li><a href="category?genreId=${genre.getGenreId()}">${genre.getName()}</a></li>
                    </c:forEach>	
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
                            <li><a href="filter">Books</a></li>
			    <li class="active">${book.getName()}</li>
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
                        <form action="addCart?id=${book.getId()}" method="post">   
                        <input name="url" value="detail?id=${book.getId()}" hidden>                        
                        <input name="id" value="${book.getId()}" hidden>                        
		        <div class="product-details">
                            <br><br><br><br>
			    <h2 class="product-name">${book.getName()}</h2>
			    <div>
				<div class="product-rating">
				    <i class="fa fa-star"></i>
				    <i class="fa fa-star"></i>
				    <i class="fa fa-star"></i>
				    <i class="fa fa-star"></i>
				    <i class="fa fa-star"></i>
				</div>
			    </div>
			    <div>
				<h3 class="product-price">$ ${book.getPrice()}</h3>
				<span class="product-available">In Stock</span>
			    </div>
                            <p></p>

			    <div class="product-options"></div>

			    <div class="add-to-cart">
				<div class="qty-label">
				    Qty
				    <div class="input-number">
				        <input name="quantity" type="number" value="${quantity}">
					<span class="qty-up">+</span>
					<span class="qty-down">-</span>
				    </div>
				</div>
				<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
			    </div>

			    <ul class="product-btns">
				<li><a href="#"><i class="fa fa-heart-o"></i> add to wishlist</a></li>
                            </ul>

			    <ul class="product-links">
				<li>Genre:</li>
                                <c:forEach items="${listGenreDetail}" var="o">
                                    <li><a href="category?genreId=${o.getGenreId()}">${o.getName()}</a></li>
                                </c:forEach>
			    </ul>

			    <ul class="product-links">
				<li>Share:</li>
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#"><i class="fa fa-envelope"></i></a></li>
			    </ul>
			</div>
                        </form>
		    </div>
		    <!-- /Product details -->

		    <!-- Product tab -->
		    <div class="col-md-12">
			<div id="product-tab">
			    <!-- product tab nav -->
			    <ul class="tab-nav">
				<li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
				<li><a data-toggle="tab" href="#tab2">Details</a></li>
                                <li><a data-toggle="tab" href="#tab3">Reviews (${number})</a></li>
			    </ul>
		            <!-- /product tab nav -->

			    <!-- product tab content -->
			    <div class="tab-content">
				<!-- tab1  -->
				<div id="tab1" class="tab-pane fade in active">
				    <div class="row">
					<div class="col-md-12">
                                            <p style="text-align: center">${book.getDescription()}</p>
					</div>
				    </div>
				</div>
				<!-- /tab1  -->

				<!-- tab2  -->
				<div id="tab2" class="tab-pane fade in">
				    <div class="row">
					<div class="col-md-12">
                                            <p style="text-align: center">Author: <a href="aubook?authorId=${author.getAuthorId()}">${author.getName()}</a></p>
                                            <p style="text-align: center"><a href="${author.getDesciption()}">See more on Wikipedia</a></p>
                                        </div>
				    </div>
				</div>
				<!-- /tab2  -->
                                
                                <!-- tab3 -->
                                <div id="tab3" class="tab-pane fade in">
				    <div class="row">
					<!-- Reviews -->
					<div class="col-md-6">
					    <div id="reviews">
						<ul class="reviews">
                                                    <%
                                                        for (Review elem : list) {
                                                    %>
						    <li>
							<div class="review-heading">
							    <h5 class="name"><%=elem.getUsername()%></h5>
							    <p class="date"><%=elem.getDate()%></p>							    
							</div>
							<div class="review-body">
							    <p><%=elem.getReview()%></p>
							</div>
						    </li>
                                                    <% } %>													
						</ul>
                                                
						<ul class="reviews-pagination">
						    <c:forEach begin="1" end="${pagesize}" var="i">
                                                        <c:choose>
                                                            <c:when test="${page==i}">                                        
                                                                <li class="active">${i}</li>                                        
                                                            </c:when>                                    
                                                            <c:otherwise>                                                
                                                                <li><a href="detail?id=${book.getId()}&page=${i}">${i}</a></li>                                                                                                                                                              
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
						</ul>
					    </div>
					</div>
					<!-- /Reviews -->

					<!-- Review Form -->
					<div class="col-md-6">
			         	    <div id="review-form">
                                                <form action="addReview" method="post" class="review-form">
                                                    <input name="url" value="${url}" hidden>
                                                    <input name="id" value="${book.getId()}" hidden>
					       	    <input type="text" name="username" class="input" value="<%=name%>" readonly>					            
						    <textarea type="text" name="review" class="input" placeholder="Your Review"></textarea>
						    <button type="submit" class="primary-btn">Submit</button>
						</form>
				            </div>
					</div>
					<!-- /Review Form -->
				    </div>
				</div>
				<!-- /tab3  -->
			    </div>
			    <!-- /product tab content  -->
			</div>
		    </div>
		    <!-- /product tab -->
		</div>
		<!-- /row -->
	    </div>
	    <!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- Section -->
	<div class="section">
	    <!-- container -->
	    <div class="container">
		<!-- row -->
		<div class="row">
                    <div class="col-md-12">
			<div class="section-title text-center">
			    <h3 class="title">Related Products</h3>
			</div>
		    </div>

		    <!-- product -->
                    <%
                        List<Book> relative = (List<Book>) request.getAttribute("relative");
                        for (Book elem : relative) {
                    %>
                        <div class="col-md-3 col-xs-6">
                            <form action="addCart?id=<%=elem.getId()%>" method="post">
			    <div class="product">
				<div class="product-img">
				    <img src="<%=elem.getImage()%>" alt="">
				</div>
				<div class="product-body">
                                    <input name="quantity" value="1" hidden>
				    <p class="product-category"><%=elem.getId()%></p>
				    <h3 class="product-name"><a href="detail?id=<%=elem.getId()%>"><%=elem.getName() %></a></h3>
				    <h4 class="product-price">$ <%=elem.getPrice()%></h4>
				    <div class="product-rating">
                                        <i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
				    </div>
				    <div class="product-btns">
					<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
					<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
				    </div>
				</div>
				<input name="url" value="<%=url%>" hidden> 
				<div class="add-to-cart">
			            <button type="submit" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
			        </div>
			    </div>
                            </form>
			</div>
                    <% } %>
		    <!-- /product -->
		</div>
		<!-- /row -->
	    </div>
	    <!-- /container -->
	</div>
	<!-- /Section -->

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
