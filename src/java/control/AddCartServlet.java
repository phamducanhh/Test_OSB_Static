/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.OrderLine;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OrderLineDAO;

/**
 *
 * @author Admin
 */
public class AddCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        OrderLineDAO oldao = new OrderLineDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            String mess = "User should login to Buy Books!";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        List<OrderLine> order = (List<OrderLine>) session.getAttribute("order");
        String url = request.getParameter("url");
        String id = request.getParameter("id");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        order = oldao.addOrder(order,id,quantity);
        session.setAttribute("order", order);
        response.sendRedirect(url);
    }

}
