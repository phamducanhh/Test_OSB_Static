/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Author;
import entity.Book;
import entity.Book_Genre;
import entity.Genre;
import entity.OrderLine;
import entity.Review;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AthorDAO;
import model.BookDAO;
import model.Book_GenreDAO;
import model.GenreDAO;
import model.OrderLineDAO;
import model.ReviewDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DetailServlet", urlPatterns = {"/detail"})
public class DetailServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        List<OrderLine> order = new ArrayList<>();
        if(session.getAttribute("order")!=null){
            order = (List<OrderLine>) session.getAttribute("order");
        }
        String id = request.getParameter("id");
        ReviewDAO rdao = new ReviewDAO();
        BookDAO bdao = new BookDAO();
        GenreDAO gdao = new GenreDAO();
        Book_GenreDAO bgdao = new Book_GenreDAO();
        AthorDAO adao = new AthorDAO();
        OrderLineDAO oldao = new OrderLineDAO();
        List<Review> listReview = rdao.getReviewbyBookId(id);
        int pageSize = listReview.size()%3==0?listReview.size()/3:listReview.size()/3+1;
        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            currentPage = 1;
        }
        OrderLine ol = oldao.getOrderLineByBookId(order, id);
        int quantity;
        quantity = ol==null?1:ol.getQuantity();
        Book book = bdao.getBookByID(id);
        List<Book> relative = bdao.getRelativeBook(book);
        Author author = adao.getAuthorByID(book.getAuthorId());
        List<Genre> listGenreDetail = bgdao.getGenreByBookId(id);
        List<Genre> listGenre = gdao.getAllGenre();
        String url = "detail?id="+id+"&page="+currentPage;
        request.setAttribute("quantity",quantity);
        request.setAttribute("relative", relative);
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("book", book);
        request.setAttribute("url", url);
        request.setAttribute("author", author);
        request.setAttribute("listGenreDetail", listGenreDetail);
        request.setAttribute("listReview",listReview.subList(3*(currentPage-1), 3*currentPage>listReview.size() ? listReview.size() : 3*currentPage));
        request.setAttribute("pagesize", pageSize);
        request.setAttribute("page", currentPage);
        request.getRequestDispatcher("Detail.jsp").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        List<OrderLine> order = new ArrayList<>();
        if(session.getAttribute("order")!=null){
            order = (List<OrderLine>) session.getAttribute("order");
        }
        String id = request.getParameter("id");
        ReviewDAO rdao = new ReviewDAO();
        BookDAO bdao = new BookDAO();
        GenreDAO gdao = new GenreDAO();
        Book_GenreDAO bgdao = new Book_GenreDAO();
        AthorDAO adao = new AthorDAO();
        OrderLineDAO oldao = new OrderLineDAO();
        List<Review> listReview = rdao.getReviewbyBookId(id);
        int pageSize = listReview.size()%3==0?listReview.size()/3:listReview.size()/3+1;
        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            currentPage = 1;
        }
        OrderLine ol = oldao.getOrderLineByBookId(order, id);
        int quantity;
        quantity = ol==null?1:ol.getQuantity();
        Book book = bdao.getBookByID(id);
        List<Book> relative = bdao.getRelativeBook(book);
        Author author = adao.getAuthorByID(book.getAuthorId());
        List<Genre> listGenreDetail = bgdao.getGenreByBookId(id);
        List<Genre> listGenre = gdao.getAllGenre();
        String url = "detail?id="+id+"&page="+currentPage;
        request.setAttribute("quantity",quantity);
        request.setAttribute("relative", relative);
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("book", book);
        request.setAttribute("url", url);
        request.setAttribute("author", author);
        request.setAttribute("listGenreDetail", listGenreDetail);
        request.setAttribute("listReview",listReview.subList(3*(currentPage-1), 3*currentPage>listReview.size() ? listReview.size() : 3*currentPage));
        request.setAttribute("pagesize", pageSize);
        request.setAttribute("page", currentPage);
        request.setAttribute("number", listReview.size());
        request.getRequestDispatcher("Detail.jsp").forward(request, response);
    }
}
