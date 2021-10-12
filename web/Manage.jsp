<%-- 
    Document   : Manage
    Created on : Jun 21, 2021, 4:35:53 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="entity.Book"%>
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
    
    <!-- SERVLET URL --> 
    <%
        String url = (String) request.getAttribute("url");
    %>
    
    <!-- NAVIGATION -->
    <nav id="navigation">
	<!-- container -->
	<div class="container">
	    <!-- responsive-nav -->
	    <div id="responsive-nav">
		<!-- NAV -->
		<ul class="main-nav nav navbar-nav">
		    <li><a href="hompage">Home</a></li>
		    <li><a href="Add.jsp">Add new Book</a></li>
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
                        <li>All Categories</li>
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
		<!-- ASIDE -->
		<div id="aside" class="col-md-3">
		    <!-- aside Widget -->
		    <div class="aside">
			<h3 class="aside-title">Categories</h3>
			<div class="checkbox-filter">
                            <form action="filterManage" method="post">
                                <c:forEach items="${listGenre}" var="genre">
                                    <div class="input-checkbox">
                                        <input type="checkbox" name="checkCate" id="${genre.getGenreId()}" value="${genre.getGenreId()}" ${genreName.contains(genre.getName())?"checked":""}>
				        <label for="${genre.getGenreId()}">
				            <span></span>
				            ${genre.getName()}
		                        </label>
                                    </div>
                                </c:forEach>
                                <p></p>
                                <div class="search-btn">
                                    <p><input type="submit" value="Filter Here">
                                </div>       
                            </form>
			</div>
		    </div>
                    <!-- /aside Widget -->
		</div>
		<!-- /ASIDE -->

		<!-- STORE -->
		<div id="store" class="col-md-9">
		    <!-- store top filter -->
		    <div class="store-filter clearfix">
			<div class="store-sort">
			    <label>
				Sort By:
                                <select class="input-select" onchange="toggleD()">
                                    <option value="0">Price Descending</option>
                                    <option value="1">Price Ascending</option>
				</select>
			    </label>
                        </div>
<!--			<ul class="store-grid">
			    <li class="active"><i class="fa fa-th"></i></li>
		        </ul>-->
		    </div>
		    <!-- /store top filter -->

		    <!-- store products -->
                    
                    <%
                        List<Book> list = (List<Book>)request.getAttribute("list");                                          
                    %>
                    <div id="toggle-tab">
                        <div class="oldest">
		            <div class="row">
                                <%! int count = 0;%>
                                <%
                                    for (Book elem : list) {
                                %>
                                    
                                <div class="col-md-4 col-xs-6">
                                    
                                        <div class="product">
				            <div class="product-img">
					        <img src="<%=elem.getImage()%>" alt="">	
				            </div>
				            <div class="product-body">
                                                <input name="quantity" value="1" hidden>
					        <p class="product-category"><%=elem.getId()%></p>
					        <h3 class="product-name"><a href="detail?id=<%=elem.getId()%>"><%=elem.getName()%></a></h3>
					        <h4 class="product-price">$ <%=elem.getPrice()%></h4>
					        <div class="product-rating">
					            <i class="fa fa-star"></i>
					            <i class="fa fa-star"></i>
					            <i class="fa fa-star"></i>
			                            <i class="fa fa-star"></i>
				                    <i class="fa fa-star"></i>
				                </div>
				                <div class="product-btns">
                                                    <button class="add-to-wishlist"><i class="fa fa-edit"></i><span class="tooltipp"><a  style="color: white" href="edit?id=<%=elem.getId()%>">edit</a></span></button>
					            <button class="quick-view"><i class="fa fa-trash-o"></i><span class="tooltipp"><a style="color: white" href="delete?id=<%=elem.getId()%>">delete</a></span></button>
				                </div>
                                            </div>
				        </div>                                           
                                    
                                </div>
                                <% count++;%>
                                <%if(count==3){%> <div class="col-md-12"></div> <%count=0;}%>
                                <% } %>
                                <%count=0;%>
		            </div>
                        </div>
                            
                        <div class="oldest" style="display: none">
		            <div class="row">
                                
                                <%
                                    List<Book> list2 = (List<Book>)request.getAttribute("list2");
                                    for (Book elem : list2) {
                                %>
                                    
                                <div class="col-md-4 col-xs-6">
                                    
                                        <div class="product">
				            <div class="product-img">
					        <img src="<%=elem.getImage()%>" alt="">	
				            </div>
				            <div class="product-body">
                                                <input name="quantity" value="1" hidden>
					        <p class="product-category"><%=elem.getId()%></p>
					        <h3 class="product-name"><a href="detail?id=<%=elem.getId()%>"><%=elem.getName()%></a></h3>
					        <h4 class="product-price">$ <%=elem.getPrice()%></h4>
					        <div class="product-rating">
					            <i class="fa fa-star"></i>
					            <i class="fa fa-star"></i>
					            <i class="fa fa-star"></i>
			                            <i class="fa fa-star"></i>
				                    <i class="fa fa-star"></i>
				                </div>
				                <div class="product-btns">
                                                    <button class="add-to-wishlist"><i class="fa fa-edit"></i><span class="tooltipp"><a  style="color: white" href="edit?id=<%=elem.getId()%>">edit</a></span></button>
					            <button class="quick-view"><i class="fa fa-trash-o"></i><span class="tooltipp"><a style="color: white" href="delete?id=<%=elem.getId()%>">delete</a></span></button>
				                </div>
				            </div>
				        </div>                                           
                                    
                                </div>
                                <% count++;%>
                                <%if(count==3){%> <div class="col-md-12"></div> <%count=0;}%>
                                <% } %>
                                <%count=0;%>
		            </div>
                        </div>                           
                    </div>
		    <!-- /store products -->

  		    <!-- store bottom filter -->
		    <div class="store-filter clearfix">
			<span class="store-qty">Showing 6 products per page</span>
                        <ul class="store-pagination" style="display: inline-block">
                            <c:forEach begin="1" end="${pagesize}" var="i">
                                <c:choose>
                                    <c:when test="${page==i}">                                        
                                        <li class="active">${i}</li>                                        
                                    </c:when>
                                    
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${url.charAt(0)=='m'}">                                                
                                                <li><a href="manage?page=${i}">${i}</a></li>                                                 
                                            </c:when>
                                      
                                            <c:otherwise>
                                                <form action="filterManage?page=${i}" method="post">
                                                <c:forEach items="${listGenre}" var="genre">
                                                    <div class="input-checkbox" hidden>
                                                        <input type="checkbox" name="checkCate" id="${genre.getGenreId()}" value="${genre.getGenreId()}" hidden ${genreName.contains(genre.getName())?"checked":""}>
                                                    </div>
                                                </c:forEach>
                                                <li><input type="submit" value="${i}"></li>  
                                                </form>
                                            </c:otherwise>
                                        </c:choose>                                                                             
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
			</ul>
		    </div>
		    <!-- /store bottom filter --> 
		</div>
		<!-- /STORE -->
	    </div>
	    <!-- /row -->
	</div>
	<!-- /container -->
    </div>
    <!-- /SECTION -->
    
    <!-- FOOTER -->
    <jsp:include page="Footer.jsp"></jsp:include>	
    <!-- /FOOTER -->

    <!-- jQuery Plugins -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/nouislider.min.js"></script>
    <script src="js/jquery.zoom.min.js"></script>
    <script src="js/main.js"></script>
    <script>
        function toggleD(){
            $('#toggle-tab .oldest').toggle();
            $('#toggle-tab .newest').toggle();
        }
    </script>
    </body>
</html>
