/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.admin;

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
import model.BookDAO;
import model.GenreDAO;

/**
 *
 * @author Admin
 */
public class ManageServlet extends HttpServlet {

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
        BookDAO bdao = new BookDAO();
        GenreDAO gdao = new GenreDAO();
        List<Book> list = bdao.getAllBook();
        Collections.sort(list);
        List<Book> list2 = bdao.getAllBook();
        Collections.sort(list2);
        Collections.reverse(list2);
        int pageSize = list.size()%6==0?list.size()/6:list.size()/6+1;
        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            currentPage = 1;
        }
        String url = "manage?page="+currentPage;
        List<Genre> listGenre = gdao.getAllGenre();
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("list",list.subList(6*(currentPage-1), 6*currentPage>list.size() ? list.size() : 6*currentPage));
        request.setAttribute("list2",list2.subList(6*(currentPage-1), 6*currentPage>list.size() ? list.size() : 6*currentPage));
        request.setAttribute("url", url);
        request.setAttribute("pagesize", pageSize);
        request.setAttribute("page", currentPage);
        request.getRequestDispatcher("Manage.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        BookDAO bdao = new BookDAO();
        GenreDAO gdao = new GenreDAO();
        List<Book> list = bdao.getAllBook();
        Collections.sort(list);
        List<Book> list2 = bdao.getAllBook();
        Collections.sort(list2);
        Collections.reverse(list2);
        int pageSize = list.size()%6==0?list.size()/6:list.size()/6+1;
        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            currentPage = 1;
        }
        String url = "manage?page="+currentPage;
        List<Genre> listGenre = gdao.getAllGenre();
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("list",list.subList(6*(currentPage-1), 6*currentPage>list.size() ? list.size() : 6*currentPage));
        request.setAttribute("list2",list2.subList(6*(currentPage-1), 6*currentPage>list.size() ? list.size() : 6*currentPage));
        request.setAttribute("url", url);
        request.setAttribute("pagesize", pageSize);
        request.setAttribute("page", currentPage);
        request.getRequestDispatcher("Manage.jsp").forward(request, response);
    }
}
