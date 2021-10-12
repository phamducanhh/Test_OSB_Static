/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Book;
import entity.Genre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Book_GenreDAO extends MyDAO{
    public List<Genre> getGenreByBookId(String id){      
        List<Genre> list = new ArrayList<>();
        xSql = "select * from Book_Genre where id=? ";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            String genreId;
            while(rs.next()){
                genreId = rs.getString("GenreId");
                GenreDAO gdao = new GenreDAO();
                Genre genre = gdao.getGenreByID(genreId);
                list.add(genre);
            }
            rs.close();
            ps.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return(list);
    }

    public void deleteGenreOfBook(String xId){
        xSql = "delete from Book_Genre where id=?";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, xId);
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateGenreOfBook(String xId, String[] arr) {
        deleteGenreOfBook(xId);
        for (int i = 0; i < arr.length; i++) {
            xSql = "INSERT INTO Book_Genre([id],[GenreId]) VALUES (?,?);";
            try{
                ps = con.prepareStatement(xSql);
                ps.setString(1, xId);
                ps.setString(2, arr[i]);
                ps.executeUpdate();
                ps.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
