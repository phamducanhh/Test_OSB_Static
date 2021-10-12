<%@page import="entity.OrderLine"%>
<%@page import="java.util.List"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- HEADER -->
    <header>
        <!-- TOP HEADER -->
	<div id="top-header">
	    <div class="container">
		<ul class="header-links pull-left">
		    <li><a href="callto://84911113052"><i class="fa fa-phone"></i> +84-911-113-052 </a></li>
		    <li><a href="http:\\gmail.com"><i class="fa fa-envelope-o"></i> anhpdhe150529@gmail.com</a></li>
		    <li><a href="https://www.google.com/search?q=fpt+university+hanoi&oq=fpt+university+hanoi&aqs=chrome..69i57j46.6323j0j15&sourceid=chrome&ie=UTF-8"><i class="fa fa-map-marker"></i> FPT University Hanoi</a></li>
		</ul>
		<ul class="header-links pull-right">
                    <% if(session.getAttribute("user")==null){ %>
		        <li><a href="Login.jsp"><i class="fa fa-user-o"> SIGN IN</i></a></li>
                    <% } else { %>
                        <li><a href="">${user.getUsername()}</a></li>
                    <%if(((User) session.getAttribute("user")).getRole()==0) { %>
                        <li><a href="manage">Manage Products</a></li>
                        <% } %>
                        <li><a href="ChangePassword.jsp">  Change Password</a></li>
                        <li><a href="logout">  Log out</a></li>
                    <% } %>
		</ul>
	    </div>
	</div>
	<!-- /TOP HEADER -->

        <%
            List<OrderLine> order = (List<OrderLine>) session.getAttribute("order");
        %>
	<!-- MAIN HEADER -->
	<div id="header">
	    <!-- container -->
	    <div class="container">
	        <!-- row -->
		<div class="row">
		    <!-- LOGO -->
		    <div class="col-md-3">
			<div class="header-logo">
			    <a href="hompage" class="logo">
				<img src="./img/logo.png" alt="">
			    </a>
			</div>
		    </div>
		    <!-- /LOGO -->

		    <!-- SEARCH BAR -->
		    <div class="col-md-6">
			<div class="header-search">
			    <form action="search" method="post">
				<input class="input" type="text" name="searchContent" placeholder="Search Books by Name">
                                <button class="search-btn" type="submit">Search</button>
			    </form>
			</div>
		    </div>
		    <!-- /SEARCH BAR -->

		    <!-- ACCOUNT -->
		    <div class="col-md-3 clearfix">
			<div class="header-ctn">
			    <!-- Wishlist -->
			    <div>
				<a href="#">
				    <i class="fa fa-heart-o"></i>
				    <span> Wishlist</span>
				    <div class="qty">0</div>       <!--    CODE HERE    -->
				</a>
			    </div>
			    <!-- /Wishlist -->

			    <!-- Cart -->          <!--CODE HERE-->
			    <div class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
				    <i class="fa fa-shopping-cart"></i>
				    <span>Shopping Cart</span>
				    <div class="qty"><%=order.size() %></div>        <!--   CODE HERE   -->
				</a>
			        <div class="cart-dropdown">
				    <div class="cart-list">
                                        <%
                                            float total=0;
                                            for (OrderLine elem : order) {
                                        %>
                                            <form action="deleteCart?id=<%= elem.getBook().getId()%>" method="post">
				                <div class="product-widget">
			                            <div class="product-img">
							<img src="<%=elem.getBook().getImage()%>" alt="">
						    </div>
                                                    
						    <div class="product-body">
							<h3 class="product-name"><a href="detail?id=<%=elem.getBook().getId()%>"><%=elem.getBook().getName()%></a></h3>
                                                        <h4 class="product-price"><span class="qty"><%=elem.getQuantity()%>x</span>$ <%=elem.getBook().getPrice()%></h4>
						    </div>
                                                    <input name="url" value="${url}" hidden>
							<button type="submit" class="delete"><i class="fa fa-close"></i></button>
						</div>
                                            </form>
                                        <% 
                                            total+=Float.parseFloat(elem.getBook().getPrice()) * elem.getQuantity();
                                            }
                                        %>
				    </div>
                                    
				    <div class="cart-summary">
					<small><%=order.size()%> Item(s) selected</small>
					<h5>SUBTOTAL: $ <%=String.format("%.2f",total)%></h5>
				    </div>
				    <div class="cart-btns">
					<a>View Cart</a>
					<a href="checkout">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
				    </div>
			        </div>
			    </div>
		            <!-- /Cart -->

			    <!-- Menu Toogle -->
			    <div class="menu-toggle">
				<a href="#">
				    <i class="fa fa-bars"></i>
				    <span>Menu</span>
				</a>
			    </div>
			    <!-- /Menu Toogle -->
			</div>
		    </div>
		    <!-- /ACCOUNT -->
		</div>
		<!-- row -->
	    </div>
	    <!-- container -->
	</div>
        <!-- /MAIN HEADER -->
    </header>
    <!-- /HEADER -->
