/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BillDAO extends MyDAO{

    public void addBill(String name, String email, String address, String zipcode, String tel, String note, String payment) {
        xSql = "insert into [dbo].[Bill]([name],[email],[address],[zipcode],[tel],[note],[payment],[date],[ship]) "
                + "values(?,?,?,?,?,?,?,GETDATE(),0)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, zipcode);
            ps.setString(5, tel);
            ps.setString(6, note);
            ps.setString(7, payment);
            ps.executeUpdate();
            ps.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Bill> getAllBill(){
        ArrayList<Bill> list = new ArrayList<>();
        xSql = "select * from [dbo].[Bill]";
        try{
            ps=con.prepareStatement(xSql);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Bill(rs.getInt("billId"), rs.getString("name"), rs.getString("email"), rs.getString("address"),
                        rs.getString("zipcode"), rs.getString("tel"), rs.getString("note"), rs.getString("payment"), rs.getDate("date"), rs.getBoolean("ship")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
