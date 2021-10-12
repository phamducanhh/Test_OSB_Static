/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends MyDAO{

    public User getUser(String xUser, String xPass) {
        User x = null;
        xSql = "SELECT * FROM [User] WHERE username = ? and password = ?"; 
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xUser);
            ps.setString(2, xPass);
            rs = ps.executeQuery();
            if(rs.next()) {
                x = new User(xUser, xPass, rs.getInt("role"));
            }
            rs.close();
            ps.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return(x);
    }

    public User addUser(String xUser, String xPass) {
        xSql = "INSERT [dbo].[User] ([username], [password], [role]) VALUES (?,?,1)";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, xUser);
            ps.setString(2, xPass);
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return new User(xUser, xPass, 1);
    }
    
    public User getUser(String xUser) {
        User x = null;
        xSql = "SELECT * FROM [User] WHERE username = ? "; 
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xUser);
            rs = ps.executeQuery();
            if(rs.next()) {
                x = new User(xUser, rs.getString("password"), rs.getInt("role"));
            }
            rs.close();
            ps.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return(x);
    }

    public User changePassUser(String xUser, String xNew) {
        User x = null;
        xSql = "update [dbo].[User] set [password] = ? where [username] = ?";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, xNew);
            ps.setString(2, xUser);
            ps.executeUpdate();
            ps.close();
            x = getUser(xUser);
        }catch(Exception e){
            e.printStackTrace();
        }
        return x;
    }
}
