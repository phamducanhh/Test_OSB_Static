/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Author;

/**
 *
 * @author Admin
 */
public class AthorDAO extends MyDAO{
    public Author getAuthorByID(String authorId){
        Author author = null;
        String name;
        String description;
        xSql = "select * from Author where authorId=?";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, authorId);
            rs = ps.executeQuery();
            if(rs.next()){
                name = rs.getString("name");
                description = rs.getString("description");
                author = new Author(authorId, name, description);
            }
            rs.close();
            ps.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return author;
    }

    public void addAuthor(String authorId, String authorName) {
        xSql = "INSERT INTO Author([authorId],[name],[description]) VALUES (?,?,null)";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, authorId);
            ps.setString(2, authorName);
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
