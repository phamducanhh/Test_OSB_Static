/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Genre {
    private int genreId;
    private String name;

    public Genre() {
    }

    public Genre(int genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isIn(List<Genre> lst){
        for (Genre genre : lst) {
            if(genre.genreId==this.genreId){
                return true;
            }
        }
        return false;
    }
}
