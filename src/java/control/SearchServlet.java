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
import model.BookDAO;
import model.GenreDAO;

/**
 *
 * @author Admin
 */
public class SearchServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String content = request.getParameter("searchContent").toLowerCase();
        BookDAO bdao = new BookDAO();
        GenreDAO gdao = new GenreDAO();
        List<Genre> listGenre = gdao.getAllGenre();
        List<Book> list = bdao.getSearchBook(content);
        List<Book> list2 = bdao.getSearchBook(content);
        Collections.sort(list);
        Collections.sort(list2);
        Collections.reverse(list2);
        List<Book> listTop = bdao.getBSellerBook();
        String url = "hompage";
        String genreName = "result of "+content;
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("genreName", genreName);
        request.setAttribute("topSell", listTop);
        request.setAttribute("list",list);
        request.setAttribute("list2",list2);
        request.setAttribute("url", url);
        request.getRequestDispatcher("Store.jsp").forward(request, response);
    }
}

