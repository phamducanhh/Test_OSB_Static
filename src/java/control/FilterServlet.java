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
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FilterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String arr[] = request.getParameterValues("checkCate");
            BookDAO bdao = new BookDAO();
            GenreDAO gdao = new GenreDAO();
            List<Genre> listGenre = gdao.getAllGenre();
            List<Book> list = bdao.getBookByFilter(arr);
            Collections.sort(list);
            List<Book> list2 = bdao.getBookByFilter(arr);
            Collections.sort(list2);
            Collections.reverse(list2);
            List<Book> listTop = bdao.getBSellerBook();
            int pageSize = list.size() % 6 == 0 ? list.size() / 6 : list.size() / 6 + 1;
            int currentPage;
            try {
                currentPage = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
                currentPage = 1;
            }
            String url = "filter?page=" + currentPage;
            String temp = "";
            if (arr == null) {
                temp += "no filter";
            } else {
                String genreName[] = new String[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    genreName[i] = gdao.getGenreByID(arr[i]).getName();
                }
                for (int i = 0; i < arr.length - 1; i++) {
                    temp += genreName[i] + ", ";
                }
                temp += genreName[arr.length - 1];
            }
            request.setAttribute("genreName", temp);
            request.setAttribute("list", list.subList(6 * (currentPage - 1), 6 * currentPage > list.size() ? list.size() : 6 * currentPage));
            request.setAttribute("list2", list2.subList(6 * (currentPage - 1), 6 * currentPage > list.size() ? list.size() : 6 * currentPage));
            request.setAttribute("listGenre", listGenre);
            request.setAttribute("topSell", listTop);
            request.setAttribute("url", url);
            request.setAttribute("pagesize", pageSize);
            request.setAttribute("page", currentPage);
            request.getRequestDispatcher("Store.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FilterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter pr = response.getWriter();
            String arr[] = request.getParameterValues("checkCate");
            BookDAO bdao = new BookDAO();
            GenreDAO gdao = new GenreDAO();
            List<Genre> listGenre = gdao.getAllGenre();
            List<Book> list = bdao.getBookByFilter(arr);
            Collections.sort(list);
            List<Book> list2 = bdao.getBookByFilter(arr);
            Collections.sort(list2);
            Collections.reverse(list2);
            List<Book> listTop = bdao.getBSellerBook();
            int pageSize = list.size() % 6 == 0 ? list.size() / 6 : list.size() / 6 + 1;
            int currentPage;
            try {
                currentPage = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
                currentPage = 1;
            }
            String url = "filter?page=" + currentPage;
            String temp = "";
            if (arr == null) {
                temp += "no filter";
            } else {
                String genreName[] = new String[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    genreName[i] = gdao.getGenreByID(arr[i]).getName();
                }
                for (int i = 0; i < arr.length - 1; i++) {
                    temp += genreName[i] + ", ";
                }
                temp += genreName[arr.length - 1];
            }
            request.setAttribute("genreName", temp);
            request.setAttribute("list", list.subList(6 * (currentPage - 1), 6 * currentPage > list.size() ? list.size() : 6 * currentPage));
            request.setAttribute("list2", list2.subList(6 * (currentPage - 1), 6 * currentPage > list.size() ? list.size() : 6 * currentPage));
            request.setAttribute("listGenre", listGenre);
            request.setAttribute("topSell", listTop);
            request.setAttribute("url", url);
            request.setAttribute("pagesize", pageSize);
            request.setAttribute("page", currentPage);
            request.getRequestDispatcher("Store.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FilterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
