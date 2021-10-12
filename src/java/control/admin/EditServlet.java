/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.admin;

import entity.Book;
import entity.Genre;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AthorDAO;
import model.BookDAO;
import model.Book_GenreDAO;
import model.GenreDAO;

/**
 *
 * @author Admin
 */
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        BookDAO bdao = new BookDAO();
        GenreDAO gdao = new GenreDAO();
        Book_GenreDAO bgdao = new Book_GenreDAO();
        Book book = bdao.getBookByID(id);
        List<Genre> listGenreDetail = bgdao.getGenreByBookId(id);
        List<Genre> listGenre = gdao.getAllGenre();
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("book", book);
        request.setAttribute("listGenreDetail", listGenreDetail);
        request.getRequestDispatcher("DetailManage.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        GenreDAO gdao = new GenreDAO();
        AthorDAO adao = new AthorDAO();
        BookDAO bdao = new BookDAO();
        Book_GenreDAO bgdao = new Book_GenreDAO();
        String mess = null;
        String xId = request.getParameter("id");
        String xName = request.getParameter("name");
        String isNewAuthor = request.getParameter("newauthor");
        String description = request.getParameter("description");
        String authorId = request.getParameter("author");
        String authorName = request.getParameter("authorname");
        String[]arr = request.getParameterValues("checkCate");
        float price = Float.parseFloat(request.getParameter("price"));
        if(isNewAuthor!=null){
            if(adao.getAuthorByID(authorId)==null){
                adao.addAuthor(authorId, authorName);
            } else {
                mess = "Error: Not New Author, uncheck is New!";
                Book book = bdao.getBookByID(xId);
                List<Genre> listGenreDetail = bgdao.getGenreByBookId(xId);
                List<Genre> listGenre = gdao.getAllGenre();
                request.setAttribute("listGenre", listGenre);
                request.setAttribute("book", book);
                request.setAttribute("listGenreDetail", listGenreDetail);
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("DetailManage.jsp").forward(request, response);
            }
        }
        if(adao.getAuthorByID(authorId)==null){
            mess = "Error: Unidentified Author";
            Book book = bdao.getBookByID(xId);
            List<Genre> listGenreDetail = bgdao.getGenreByBookId(xId);
            List<Genre> listGenre = gdao.getAllGenre();
            request.setAttribute("listGenre", listGenre);
            request.setAttribute("book", book);
            request.setAttribute("listGenreDetail", listGenreDetail);
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("DetailManage.jsp").forward(request, response);
        }
        bgdao.updateGenreOfBook(xId,arr);
        bdao.editBook(xId,xName,authorId,description,price);
        response.sendRedirect("manage");
    }
    
}
