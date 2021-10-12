/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.OrderLine;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderLineDAO extends MyDAO{

    public OrderLine getOrderLineByBookId(List<OrderLine> order, String id){
        BookDAO bdao = new BookDAO();
        for (OrderLine orderLine : order) {
            if(orderLine.getBook().getId().equals(id)) return orderLine;
        }
        return null;
    }
    
    public List<OrderLine> addOrder(List<OrderLine> order, String id, int quantity) {
        BookDAO bdao = new BookDAO();
        if(getOrderLineByBookId(order, id)!=null){
            OrderLine o = getOrderLineByBookId(order, id);
            o.setQuantity(quantity);
        }else{
            order.add(new OrderLine(bdao.getBookByID(id), quantity));
        }
        return order;
    }

    public List<OrderLine> removeOrder(List<OrderLine> order, String id) {
        OrderLine o = getOrderLineByBookId(order, id);
        order.remove(o);
        return order;
    }

    public void addOrdertoDTB(int id, String id0, int quantity) {
        xSql = "insert into [dbo].[OrderLine]([billId],[id],[quantity]) values (?,?,?) ";
        try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            ps.setString(2, id0);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}
