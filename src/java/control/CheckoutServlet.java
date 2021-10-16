/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Book;
import entity.Genre;
import entity.OrderLine;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BillDAO;
import model.BookDAO;
import model.GenreDAO;
import model.OrderLineDAO;

/**
 *
 * @author Admin
 */
public class CheckoutServlet extends HttpServlet {

    protected boolean isTel(String input){
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) return false;
        }
        return true;
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        GenreDAO gdao = new GenreDAO();
        List<Genre> listGenre = gdao.getAllGenre();
        List<OrderLine> order = new ArrayList<>();
        if(session.getAttribute("order")!=null){
            order = (List<OrderLine>) session.getAttribute("order");
        }
        request.setAttribute("listGenre", listGenre);
        session.setAttribute("order", order);
        session.getAttribute("order");
        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mess = "";
        HttpSession session = request.getSession();
        if(session.getAttribute("order")==null||((List<OrderLine>)session.getAttribute("order")).isEmpty()){
            List<OrderLine> order = new ArrayList<>();
            GenreDAO gdao = new GenreDAO();
            List<Genre> listGenre = gdao.getAllGenre();
            mess+="Your Cart is Empty!";
            request.setAttribute("listGenre", listGenre);
            session.setAttribute("order", order);
            session.getAttribute("order");
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Checkout.jsp").forward(request, response);
        }else{
            List<OrderLine> order = (List<OrderLine>)session.getAttribute("order");
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String address=request.getParameter("address");
            String zipcode=request.getParameter("zipcode");
            String tel=request.getParameter("tel");
            String note=request.getParameter("note");
            String payment=request.getParameter("payment");
            if(!isTel(tel)){
                mess+="Invalid telephone number!";
                GenreDAO gdao = new GenreDAO();
                List<Genre> listGenre = gdao.getAllGenre();
                request.setAttribute("listGenre", listGenre);
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("Checkout.jsp").forward(request, response);
            } else {
                BillDAO bdao = new BillDAO();
                bdao.addBill(name,email,address,zipcode,tel,note,payment);
                OrderLineDAO oldao = new OrderLineDAO();
                for (OrderLine orderLine : order) {
                    oldao.addOrdertoDTB(bdao.getAllBill().get(bdao.getAllBill().size()-1).getId(),orderLine.getBook().getId(),orderLine.getQuantity());
                }
                List<OrderLine> orderNew = new ArrayList<>();
                session.setAttribute("order", orderNew);
                response.sendRedirect("hompage");
            }
        }
        
    }

}
