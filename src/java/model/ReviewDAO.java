/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Review;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ReviewDAO extends MyDAO{
    public List<Review> getReviewbyBookId(String id){
        List<Review> list = new ArrayList<>();
        xSql = "select * from [dbo].[Review] where id=? order by [date]";
        try{
            ps=con.prepareStatement(xSql);
            ps.setString(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Review(id, rs.getString("username"), rs.getString("review"), rs.getDate("date")));
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void addReview(String id, String username, String review) {
        xSql = "insert into [dbo].[Review]([id],[username],[review],[date]) values(?,?,?,GETDATE())";
        try{
            ps=con.prepareStatement(xSql);
            ps.setString(1, id);
            ps.setString(2, username);
            ps.setString(3, review);
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
