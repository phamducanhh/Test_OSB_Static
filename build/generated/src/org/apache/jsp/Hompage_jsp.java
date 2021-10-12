package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Hompage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("    <title>A book a day | Give the stress away</title>\n");
      out.write("    <!-- Google font -->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,500,700\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap -->\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.min.css\"/>\n");
      out.write("\n");
      out.write("    <!-- Slick -->\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"css/slick.css\"/>\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"css/slick-theme.css\"/>\n");
      out.write("\n");
      out.write("    <!-- nouislider -->\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"css/nouislider.min.css\"/>\n");
      out.write("\n");
      out.write("    <!-- Font Awesome Icon -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("    <!-- Custom stlylesheet -->\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\"/>\n");
      out.write("\n");
      out.write("\t\t<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("\t\t<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("\t\t<!--[if lt IE 9]>\n");
      out.write("\t\t  <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("\t\t  <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("\t\t<![endif]-->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("    <!-- NAVIGATION -->\n");
      out.write("    <nav id=\"navigation\">\n");
      out.write("\t<!-- container -->\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t    <!-- responsive-nav -->\n");
      out.write("\t    <div id=\"responsive-nav\">\n");
      out.write("\t\t<!-- NAV -->\n");
      out.write("\t\t<ul class=\"main-nav nav navbar-nav\">\n");
      out.write("\t\t    <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t</ul>\n");
      out.write("\t        <!-- /NAV -->\n");
      out.write("\t    </div>\n");
      out.write("\t    <!-- /responsive-nav -->\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /container -->\n");
      out.write("    </nav>\n");
      out.write("    <!-- /NAVIGATION -->\n");
      out.write("\n");
      out.write("    <!-- SECTION -->\n");
      out.write("    <div class=\"section\">\n");
      out.write("\t<!-- container -->\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t    <!-- row -->\n");
      out.write("\t    <div class=\"row\">\n");
      out.write("\t\t<!-- shop -->\n");
      out.write("\t\t<div class=\"col-md-4 col-xs-6\">\n");
      out.write("\t\t    <div class=\"shop\">\n");
      out.write("\t\t        <div class=\"shop-img\">\n");
      out.write("                            <img src=\"./img/ATTWNN0021.png\" alt=\"\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"shop-body\">\n");
      out.write("\t\t\t    <h3>Agatha Christie<br>Collection</h3>\n");
      out.write("\t\t\t    <a href=\"aubook?authorId=AGTCRTE001\" class=\"cta-btn\">Shop now <i class=\"fa fa-arrow-circle-right\"></i></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- /shop -->\n");
      out.write("\n");
      out.write("\t\t<!-- shop -->\n");
      out.write("\t\t<div class=\"col-md-4 col-xs-6\">\n");
      out.write("\t\t    <div class=\"shop\">\n");
      out.write("\t\t\t<div class=\"shop-img\">\n");
      out.write("                            <img src=\"./img/LRDRNG0012.png\" alt=\"\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"shop-body\">\n");
      out.write("                            <h3>J. R. R Tolkien<br>Collection</h3>\n");
      out.write("\t\t\t    <a href=\"aubook?authorId=JRRTKEN001\" class=\"cta-btn\">Shop now <i class=\"fa fa-arrow-circle-right\"></i></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- /shop -->\n");
      out.write("\n");
      out.write("\t\t<!-- shop -->\n");
      out.write("\t\t<div class=\"col-md-4 col-xs-6\">\n");
      out.write("\t\t    <div class=\"shop\">\n");
      out.write("\t\t\t<div class=\"shop-img\">\n");
      out.write("                            <img src=\"./img/HWMVCS0010.png\" alt=\"\">\n");
      out.write("\t\t        </div>\n");
      out.write("\t\t\t<div class=\"shop-body\">\n");
      out.write("                            <h3>Diana Wynne Jones<br>Collection</h3>\n");
      out.write("\t\t\t    <a href=\"aubook?authorId=DNWNJHN001\" class=\"cta-btn\">Shop now <i class=\"fa fa-arrow-circle-right\"></i></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- /shop -->\n");
      out.write("\t    </div>\n");
      out.write("\t    <!-- /row -->\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /container -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /SECTION -->\n");
      out.write("\n");
      out.write("    <!-- SECTION -->\n");
      out.write("    <div class=\"section\">\n");
      out.write("\t<!-- container -->\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t    <!-- row -->\n");
      out.write("\t    <div class=\"row\">\n");
      out.write("\t\t\n");
      out.write("                <!-- section title -->\n");
      out.write("\t\t<div class=\"col-md-12\">\n");
      out.write("\t\t    <div class=\"section-title\">\n");
      out.write("\t\t\t<h3 class=\"title\">New Books</h3>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- /section title -->\n");
      out.write("\n");
      out.write("\t\t<!-- Products tab & slick -->\n");
      out.write("\t\t<div class=\"col-md-12\">\n");
      out.write("\t\t    <div class=\"row\">\n");
      out.write("\t\t\t<div class=\"products-tabs\">\n");
      out.write("\t\t\t    <!-- tab -->\n");
      out.write("\t\t\t    <div id=\"tab1\" class=\"tab-pane active\">\n");
      out.write("\t\t\t\t<div class=\"products-slick\" data-nav=\"#slick-nav-1\">\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t        <div id=\"slick-nav-1\" class=\"products-slick-nav\"></div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t    <!-- /tab -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t        <!-- Products tab & slick -->\n");
      out.write("\t    </div>\n");
      out.write("\t    <!-- /row -->\n");
      out.write("\t</div>\n");
      out.write("        <!-- /container -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /SECTION -->\n");
      out.write("\n");
      out.write("    <!-- SECTION -->\n");
      out.write("    <div class=\"section\">\n");
      out.write("\t<!-- container -->\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t    <!-- row -->\n");
      out.write("\t    <div class=\"row\">\n");
      out.write("\n");
      out.write("\t\t<!-- section title -->\n");
      out.write("\t\t<div class=\"col-md-12\">\n");
      out.write("\t\t    <div class=\"section-title\">\n");
      out.write("\t\t\t<h3 class=\"title\">Top selling</h3>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t        <!-- /section title -->\n");
      out.write("\n");
      out.write("\t\t<!-- Products tab & slick -->\n");
      out.write("\t\t<div class=\"col-md-12\">\n");
      out.write("\t\t    <div class=\"row\">\n");
      out.write("\t\t\t<div class=\"products-tabs\">\n");
      out.write("\t\t\t    <!-- tab -->\n");
      out.write("\t\t\t    <div id=\"tab2\" class=\"tab-pane fade in active\">\n");
      out.write("\t\t\t\t<div class=\"products-slick\" data-nav=\"#slick-nav-2\">\n");
      out.write("\t\t                    ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div id=\"slick-nav-2\" class=\"products-slick-nav\"></div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t    <!-- /tab -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- /Products tab & slick -->\n");
      out.write("\t    </div>\n");
      out.write("\t    <!-- /row -->\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /container -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /SECTION -->\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("    <!-- jQuery Plugins -->\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/slick.min.js\"></script>\n");
      out.write("    <script src=\"js/nouislider.min.js\"></script> \n");
      out.write("    <script src=\"js/jquery.zoom.min.js\"></script>\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listGenre}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("genre");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <li><a href=\"category?genreId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${genre.getGenreId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${genre.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${newBook}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("book");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <form action=\"addCart?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" method=\"post\">\n");
          out.write("                                        <div class=\"product\">\n");
          out.write("                                            <div class=\"product-img\">\n");
          out.write("                                                <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getImage()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\n");
          out.write("                                                <div class=\"product-label\">\n");
          out.write("                                                    <span class=\"new\">NEW</span>\n");
          out.write("                                                </div>\n");
          out.write("                                            </div>\n");
          out.write("                                            <div class=\"product-body\">\n");
          out.write("                                                <p class=\"product-category\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                                                <h3 class=\"product-name\"><a href=\"detail?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h3>\n");
          out.write("                                                <h4 class=\"product-price\">$ ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\n");
          out.write("                                                <div class=\"product-rating\">\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t        </div>\n");
          out.write("                                                <div class=\"product-btns\">\n");
          out.write("\t\t\t\t\t\t    <button class=\"add-to-wishlist\"><i class=\"fa fa-heart-o\"></i><span class=\"tooltipp\">add to wishlist</span></button>\n");
          out.write("\t\t\t\t\t\t    <button class=\"quick-view\"><i class=\"fa fa-eye\"></i><span class=\"tooltipp\">quick view</span></button>\n");
          out.write("\t\t\t\t\t        </div>\n");
          out.write("                                            </div>\n");
          out.write("                            <!--URL Pattern-->  <input name=\"url\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" hidden>\n");
          out.write("                            <!--Quantity-->     <input name=\"quantity\" value=\"1\" hidden>\n");
          out.write("                                            <div class=\"add-to-cart\">\n");
          out.write("\t\t\t\t\t        <button class=\"add-to-cart-btn\"><i class=\"fa fa-shopping-cart\"></i> add to cart</button>\n");
          out.write("\t\t\t\t\t    </div>\n");
          out.write("                                        </div>\n");
          out.write("                                        </form>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bestSeller}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("book");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <form action=\"addCart?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" method=\"post\">\n");
          out.write("                                        <div class=\"product\">\n");
          out.write("                                            <div class=\"product-img\">\n");
          out.write("                                                <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getImage()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\n");
          out.write("                                                <div class=\"product-label\">\n");
          out.write("                                                    <span class=\"new\">Best Seller</span>\n");
          out.write("                                                </div>\n");
          out.write("                                            </div>\n");
          out.write("                                            <div class=\"product-body\">\n");
          out.write("                                                <p class=\"product-category\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                                                <h3 class=\"product-name\"><a href=\"detail?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h3>\n");
          out.write("                                                <h4 class=\"product-price\">$ ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.getPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\n");
          out.write("                                                <div class=\"product-rating\">\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t\t    <i class=\"fa fa-star\"></i>\n");
          out.write("\t\t\t\t\t        </div>\n");
          out.write("                                                <div class=\"product-btns\">\n");
          out.write("\t\t\t\t\t\t    <button class=\"add-to-wishlist\"><i class=\"fa fa-heart-o\"></i><span class=\"tooltipp\">add to wishlist</span></button>\n");
          out.write("\t\t\t\t\t\t    <button class=\"quick-view\"><i class=\"fa fa-eye\"></i><span class=\"tooltipp\">quick view</span></button>\n");
          out.write("\t\t\t\t\t        </div>\n");
          out.write("                                            </div>\n");
          out.write("                            <!--URL Pattern-->  <input name=\"url\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" hidden>\n");
          out.write("                            <!--Quantity-->     <input name=\"quantity\" value=\"1\" hidden>\n");
          out.write("                                            <div class=\"add-to-cart\">\n");
          out.write("\t\t\t\t\t        <button class=\"add-to-cart-btn\"><i class=\"fa fa-shopping-cart\"></i> add to cart</button>\n");
          out.write("\t\t\t\t\t    </div>\n");
          out.write("                                        </div>\n");
          out.write("                                        </form>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
