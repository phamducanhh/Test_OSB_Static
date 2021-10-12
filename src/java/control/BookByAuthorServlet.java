/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Book;
import entity.Genre;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AthorDAO;
import model.BookDAO;
import model.GenreDAO;

/**
 *
 * @author Admin
 */
public class BookByAuthorServlet extends HttpServlet {

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
        String authorId = request.getParameter("authorId");
        BookDAO bdao = new BookDAO();
        GenreDAO gdao = new GenreDAO();
        AthorDAO adao = new AthorDAO();
        List<Genre> listGenre = gdao.getAllGenre();
        List<Book> list = bdao.getBookByAuthorID(authorId);
        List<Book> listTop = bdao.getBSellerBook();
        String genreName = adao.getAuthorByID(authorId).getName();
        List<Book> list2 = bdao.getBookByAuthorID(authorId);
        Collections.sort(list);
        Collections.sort(list2);
        Collections.reverse(list2);
        int pageSize = list.size()%6==0?list.size()/6:list.size()/6+1;
        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            currentPage = 1;
        }
        String url = "aubook?authorId="+authorId+"&page="+currentPage;
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("genreName", genreName);
        request.setAttribute("topSell", listTop);
        request.setAttribute("list",list.subList(6*(currentPage-1), 6*currentPage>list.size() ? list.size() : 6*currentPage));
        request.setAttribute("list2",list2.subList(6*(currentPage-1), 6*currentPage>list.size() ? list.size() : 6*currentPage));
        request.setAttribute("url",url);
        request.setAttribute("pagesize", pageSize);
        request.setAttribute("page", currentPage);
        request.getRequestDispatcher("Store.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
