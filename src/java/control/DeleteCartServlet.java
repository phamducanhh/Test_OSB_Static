/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.OrderLine;
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
public class DeleteCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        OrderLineDAO oldao = new OrderLineDAO();
        HttpSession session = request.getSession();
        List<OrderLine> order = (List<OrderLine>) session.getAttribute("order");
        String url = request.getParameter("url");
        String id = request.getParameter("id");
        order = oldao.removeOrder(order,id);
        session.setAttribute("order", order);
        response.sendRedirect(url);
    }
}
