<%@page import="entity.OrderLine"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <jsp:include page="Header.jsp"></jsp:include>
    
    <!-- NAVIGATION -->
    <nav id="navigation">
	<!-- container -->
	<div class="container">
	    <!-- responsive-nav -->
	    <div id="responsive-nav">
		<!-- NAV -->
		<ul class="main-nav nav navbar-nav">
		    <li class="active"><a href="#">Home</a></li>
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
		    <h3 class="breadcrumb-header">Checkout</h3>
			<ul class="breadcrumb-tree">
			    <li><a href="hompage">Home</a></li>
			    <li class="active">Checkout</li>
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
                <form action="checkout" method="post">
		<div class="col-md-7">
                
		<!-- Billing Details -->
		    <div class="billing-details">
			<div class="section-title">
			    <h3 class="title">Billing address</h3>
			</div>
			<div class="form-group">
			    <input class="input" type="text" name="name" placeholder="Name">
			</div>
			<div class="form-group">
			    <input class="input" type="text" name="email" placeholder="Email">
			</div>
			<div class="form-group">
			    <input class="input" type="text" name="address" placeholder="Address">
			</div>
			<div class="form-group">
			    <input class="input" type="text" name="zipcode" placeholder="ZIP Code">
			</div>
			<div class="form-group">
			    <input class="input" type="text" name="tel" placeholder="Telephone">
			</div>	
		    </div>
		    <!-- /Billing Details -->

		    <!-- Order notes -->
		    <div class="order-notes">
			<textarea class="input" name="note" placeholder="Order Notes"></textarea>
		    </div>
                
		    <!-- /Order notes -->
		</div>

		<!-- Order Details -->
		<div class="col-md-5 order-details">
		    <div class="section-title text-center">
			<h3 class="title">Your Order</h3>
		    </div>
		    <div class="order-summary">
			<div class="order-col">
			    <div><strong>PRODUCT</strong></div>
			    <div><strong>TOTAL</strong></div>
			</div>
                        
			<div class="order-products">
                            <%
                                float total=0;
                                List<OrderLine> order = (List<OrderLine>) session.getAttribute("order");
                                for (OrderLine elem : order) {
                                    total+=elem.getQuantity() * Float.parseFloat(elem.getBook().getPrice());
                            %>
				<div class="order-col">
				    <div><%=elem.getQuantity()%>x <%=elem.getBook().getName()%></div>
                                    <div>$ <%=String.format("%.2f", elem.getQuantity() * Float.parseFloat(elem.getBook().getPrice()))%></div>
				</div>
                            <% } %>
							
			    <div class="order-col">
				<div>Shiping</div>
				<div><strong>FREE</strong></div>
			    </div>
			    <div class="order-col">
				<div><strong>TOTAL</strong></div>
                                <div><strong class="order-total">$ <%=String.format("%.2f", total) %></strong></div>
			    </div>
			</div>
			<div class="payment-method">
			    <div class="input-radio">
				<input type="radio" name="payment" value="cash" id="payment-1">
				<label for="payment-1">
				    <span></span>
				    Pay by Cash
				</label>
				<div class="caption">
				    <p>Pay by cash after shipping, please sign the bill after checking products.</p>
				</div>
			    </div>
                            
			    <div class="input-radio">
                                <input type="radio" name="payment" value="bank" id="payment-2">
				<label for="payment-2">
				    <span></span>
				    Bank Transfer
				</label>
				<div class="caption">
				    <p>Scan this QR Code for Internet Banking. QR Code:...</p>
				</div>
			    </div>							
                        </div>
			<h6 style="color: red" style="font-size: small" >${mess}</h6>
                            <input type="submit" class="primary-btn order-submit" value="Place order">
		    </div>
		    <!-- /Order Details -->
		</div>
                </form>
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
