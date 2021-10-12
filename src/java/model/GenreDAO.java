/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Genre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GenreDAO extends MyDAO{
    public List<Genre> getAllGenre(){
        List<Genre> list = new ArrayList<>();
        xSql = "select * from Genre";
        try{
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String name;
            int genreId;
            Genre genre;
            while(rs.next()){
                genreId = rs.getInt("genreId");
                name = rs.getString("name");
                genre = new Genre(genreId, name);
                list.add(genre);
            }
            rs.close();
            ps.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return(list);
    }
    
    public Genre getGenreByID(String genreId){
        Genre genre = null;
        String name;
        xSql = "select * from Genre where genreId=?";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, genreId);
            rs = ps.executeQuery();
            if(rs.next()){
                name = rs.getString("name");
                genre = new Genre(Integer.parseInt(genreId), name);
            }
            rs.close();
            ps.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return genre;
    }
}
