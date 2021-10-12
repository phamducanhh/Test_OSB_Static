package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.OrderLine;
import java.util.List;
import entity.User;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!-- HEADER -->\n");
      out.write("    <header>\n");
      out.write("        <!-- TOP HEADER -->\n");
      out.write("\t<div id=\"top-header\">\n");
      out.write("\t    <div class=\"container\">\n");
      out.write("\t\t<ul class=\"header-links pull-left\">\n");
      out.write("\t\t    <li><a href=\"callto://84911113052\"><i class=\"fa fa-phone\"></i> +84-911-113-052 </a></li>\n");
      out.write("\t\t    <li><a href=\"http:\\\\gmail.com\"><i class=\"fa fa-envelope-o\"></i> anhpdhe150529@gmail.com</a></li>\n");
      out.write("\t\t    <li><a href=\"https://www.google.com/search?q=fpt+university+hanoi&oq=fpt+university+hanoi&aqs=chrome..69i57j46.6323j0j15&sourceid=chrome&ie=UTF-8\"><i class=\"fa fa-map-marker\"></i> FPT University Hanoi</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t\t<ul class=\"header-links pull-right\">\n");
      out.write("                    ");
 if(session.getAttribute("user")==null){ 
      out.write("\n");
      out.write("\t\t        <li><a href=\"Login.jsp\"><i class=\"fa fa-user-o\"> SIGN IN</i></a></li>\n");
      out.write("                    ");
 } else { 
      out.write("\n");
      out.write("                        <li><a href=\"\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("                    ");
if(((User) session.getAttribute("user")).getRole()==0) { 
      out.write("\n");
      out.write("                        <li><a href=\"manage\">Manage Products</a></li>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                        <li><a href=\"ChangePassword.jsp\">  Change Password</a></li>\n");
      out.write("                        <li><a href=\"logout\">  Log out</a></li>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("\t\t</ul>\n");
      out.write("\t    </div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /TOP HEADER -->\n");
      out.write("\n");
      out.write("        ");

            List<OrderLine> order = (List<OrderLine>) session.getAttribute("order");
        
      out.write("\n");
      out.write("\t<!-- MAIN HEADER -->\n");
      out.write("\t<div id=\"header\">\n");
      out.write("\t    <!-- container -->\n");
      out.write("\t    <div class=\"container\">\n");
      out.write("\t        <!-- row -->\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t    <!-- LOGO -->\n");
      out.write("\t\t    <div class=\"col-md-3\">\n");
      out.write("\t\t\t<div class=\"header-logo\">\n");
      out.write("\t\t\t    <a href=\"hompage\" class=\"logo\">\n");
      out.write("\t\t\t\t<img src=\"./img/logo.png\" alt=\"\">\n");
      out.write("\t\t\t    </a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t    <!-- /LOGO -->\n");
      out.write("\n");
      out.write("\t\t    <!-- SEARCH BAR -->\n");
      out.write("\t\t    <div class=\"col-md-6\">\n");
      out.write("\t\t\t<div class=\"header-search\">\n");
      out.write("\t\t\t    <form action=\"search\" method=\"post\">\n");
      out.write("\t\t\t\t<input class=\"input\" type=\"text\" name=\"searchContent\" placeholder=\"Search Books by Name\">\n");
      out.write("                                <button class=\"search-btn\" type=\"submit\">Search</button>\n");
      out.write("\t\t\t    </form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t    <!-- /SEARCH BAR -->\n");
      out.write("\n");
      out.write("\t\t    <!-- ACCOUNT -->\n");
      out.write("\t\t    <div class=\"col-md-3 clearfix\">\n");
      out.write("\t\t\t<div class=\"header-ctn\">\n");
      out.write("\t\t\t    <!-- Wishlist -->\n");
      out.write("\t\t\t    <div>\n");
      out.write("\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t    <i class=\"fa fa-heart-o\"></i>\n");
      out.write("\t\t\t\t    <span> Wishlist</span>\n");
      out.write("\t\t\t\t    <div class=\"qty\">0</div>       <!--    CODE HERE    -->\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t    <!-- /Wishlist -->\n");
      out.write("\n");
      out.write("\t\t\t    <!-- Cart -->          <!--CODE HERE-->\n");
      out.write("\t\t\t    <div class=\"dropdown\">\n");
      out.write("\t\t\t\t<a class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"true\">\n");
      out.write("\t\t\t\t    <i class=\"fa fa-shopping-cart\"></i>\n");
      out.write("\t\t\t\t    <span>Shopping Cart</span>\n");
      out.write("\t\t\t\t    <div class=\"qty\">");
      out.print(order.size() );
      out.write("</div>        <!--   CODE HERE   -->\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t        <div class=\"cart-dropdown\">\n");
      out.write("\t\t\t\t    <div class=\"cart-list\">\n");
      out.write("                                        ");

                                            float total=0;
                                            for (OrderLine elem : order) {
                                        
      out.write("\n");
      out.write("                                            <form action=\"deleteCart?id=");
      out.print( elem.getBook().getId());
      out.write("\" method=\"post\">\n");
      out.write("\t\t\t\t                <div class=\"product-widget\">\n");
      out.write("\t\t\t                            <div class=\"product-img\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.print(elem.getBook().getImage());
      out.write("\" alt=\"\">\n");
      out.write("\t\t\t\t\t\t    </div>\n");
      out.write("                                                    \n");
      out.write("\t\t\t\t\t\t    <div class=\"product-body\">\n");
      out.write("\t\t\t\t\t\t\t<h3 class=\"product-name\"><a href=\"detail?id=");
      out.print(elem.getBook().getId());
      out.write('"');
      out.write('>');
      out.print(elem.getBook().getName());
      out.write("</a></h3>\n");
      out.write("                                                        <h4 class=\"product-price\"><span class=\"qty\">");
      out.print(elem.getQuantity());
      out.write("x</span>$ ");
      out.print(elem.getBook().getPrice());
      out.write("</h4>\n");
      out.write("\t\t\t\t\t\t    </div>\n");
      out.write("                                                    <input name=\"url\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" hidden>\n");
      out.write("\t\t\t\t\t\t\t<button type=\"submit\" class=\"delete\"><i class=\"fa fa-close\"></i></button>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("                                            </form>\n");
      out.write("                                        ");
 
                                            total+=Float.parseFloat(elem.getBook().getPrice()) * elem.getQuantity();
                                            }
                                        
      out.write("\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("                                    \n");
      out.write("\t\t\t\t    <div class=\"cart-summary\">\n");
      out.write("\t\t\t\t\t<small>");
      out.print(order.size());
      out.write(" Item(s) selected</small>\n");
      out.write("\t\t\t\t\t<h5>SUBTOTAL: $ ");
      out.print(String.format("%.2f",total));
      out.write("</h5>\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t    <div class=\"cart-btns\">\n");
      out.write("\t\t\t\t\t<a>View Cart</a>\n");
      out.write("\t\t\t\t\t<a href=\"checkout\">Checkout  <i class=\"fa fa-arrow-circle-right\"></i></a>\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t            <!-- /Cart -->\n");
      out.write("\n");
      out.write("\t\t\t    <!-- Menu Toogle -->\n");
      out.write("\t\t\t    <div class=\"menu-toggle\">\n");
      out.write("\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t    <i class=\"fa fa-bars\"></i>\n");
      out.write("\t\t\t\t    <span>Menu</span>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t    <!-- /Menu Toogle -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t    <!-- /ACCOUNT -->\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- row -->\n");
      out.write("\t    </div>\n");
      out.write("\t    <!-- container -->\n");
      out.write("\t</div>\n");
      out.write("        <!-- /MAIN HEADER -->\n");
      out.write("    </header>\n");
      out.write("    <!-- /HEADER -->\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
