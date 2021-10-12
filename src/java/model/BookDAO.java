/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Book;
import entity.Genre;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BookDAO extends MyDAO {

    public List<Book> getAllBook() {
        List<Book> list = new ArrayList<>();
        xSql = "select * from Book";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String id, name, image, authorId, publisherId, description;
            float price;
            Book book;
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                image = rs.getString("image");
                authorId = rs.getString("authorId");
                publisherId = rs.getString("publisherId");
                description = rs.getString("description");
                price = rs.getFloat("price");
                book = new Book(id, name, image, authorId, publisherId, description, price);
                list.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public Book getBookByID(String id) {
        Book book = null;
        String name, image, authorId, publisherId, description;
        float price;
        xSql = "select * from Book where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
                image = rs.getString("image");
                authorId = rs.getString("authorId");
                publisherId = rs.getString("publisherId");
                description = rs.getString("description");
                price = rs.getFloat("price");
                book = new Book(id, name, image, authorId, publisherId, description, price);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    //slick 7 newest book by substring(id,7,4)
    public List<Book> getNewBook() {
        List<Book> list = new ArrayList<>();
        xSql = "select top 7 * from Book order by SUBSTRING(id,7,4) desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String id, name, image, authorId, publisherId, description;
            float price;
            Book book;
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                image = rs.getString("image");
                authorId = rs.getString("authorId");
                publisherId = rs.getString("publisherId");
                description = rs.getString("description");
                price = rs.getFloat("price");
                book = new Book(id, name, image, authorId, publisherId, description, price);
                list.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public List<Book> getBSellerBook() {
        List<Book> list = new ArrayList<>();
        xSql = "select top 7 b.id,b.name,b.[image],b.authorId,b.publisherId,b.[description],b.price, Sum(quantity) as Qty \n"
                + "from OrderLine o inner join Book b on (o.id=b.id)\n"
                + "group by b.id,b.name,b.[image],b.authorId,b.publisherId,b.[description],b.price\n"
                + "order by Qty desc, b.price desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String id, name, image, authorId, publisherId, description;
            float price;
            Book book;
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                image = rs.getString("image");
                authorId = rs.getString("authorId");
                publisherId = rs.getString("publisherId");
                description = rs.getString("description");
                price = rs.getFloat("price");
                book = new Book(id, name, image, authorId, publisherId, description, price);
                list.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(list.size()<7){
            List<Book> sub = getNewBook();
            int count = 7-list.size();
            while(count>0){
                for (Book book : sub) {
                    if(!isDuplicate(list, book.getId())){
                        list.add(new Book(book.getId(),book.getName(),book.getImage(),book.getAuthorId(),
                        book.getPublisherId(),book.getDescription(),Float.parseFloat(book.getPrice())));
                        count--;
                    }
                }
            }
        }
        return (list);
    }

    public List<Book> getBookByGenreId(String genreId) {
        List<Book> list = new ArrayList<>();
        xSql = "select * from Book b INNER JOIN Book_Genre bg on (b.id=bg.id) where GenreId=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, genreId);
            rs = ps.executeQuery();
            String id, name, image, authorId, publisherId, description;
            float price;
            Book book;
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                image = rs.getString("image");
                authorId = rs.getString("authorId");
                publisherId = rs.getString("publisherId");
                description = rs.getString("description");
                price = rs.getFloat("price");
                book = new Book(id, name, image, authorId, publisherId, description, price);
                list.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public boolean isDuplicate(List<Book> book, String id) {
        for (Book o : book) {
            if (o.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<Book> getBookByFilter(String[] arr) throws SQLException {
        List<Book> list = new ArrayList<>();
        if (arr == null) {
            xSql = "select * from Book";
            ps = con.prepareStatement(xSql);
        } else {
            xSql = "select b.id,b.name,b.[image],b.authorId,b.publisherId,b.description,b.price,count(b.id) from Book b INNER JOIN Book_Genre bg on (b.id=bg.id) where (";
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    xSql += "GenreId=" + arr[i];
                } else {
                    xSql += "GenreId=" + arr[i] + " or ";
                }
            }
            xSql += ") ";
            xSql += "group by b.id,b.name,b.[image],b.authorId,b.publisherId,b.[description],b.price having COUNT(b.id)=?";
            ps = con.prepareStatement(xSql);
            ps.setString(1, Integer.toString(arr.length));
        }
        try {
            rs = ps.executeQuery();
            String id, name, image, authorId, publisherId, description;
            float price;
            Book book;
            while (rs.next()) {
                id = rs.getString("id");
                if (!isDuplicate(list, id)) {
                    name = rs.getString("name");
                    image = rs.getString("image");
                    authorId = rs.getString("authorId");
                    publisherId = rs.getString("publisherId");
                    description = rs.getString("description");
                    price = rs.getFloat("price");
                    book = new Book(id, name, image, authorId, publisherId, description, price);
                    list.add(book);
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public List<Book> getBookByAuthorID(String authorId) {
        List<Book> list = new ArrayList<>();
        xSql = "select * from Book where authorId=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, authorId);
            rs = ps.executeQuery();
            String id, name, image, publisherId, description;
            float price;
            Book book;
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                image = rs.getString("image");
                publisherId = rs.getString("publisherId");
                description = rs.getString("description");
                price = rs.getFloat("price");
                book = new Book(id, name, image, authorId, publisherId, description, price);
                list.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public List<Book> getRelativeBook(Book book) {
        List<Book> a = getBookByAuthorID(book.getAuthorId());
        Book_GenreDAO bgdao = new Book_GenreDAO();
        List<Genre> temp = bgdao.getGenreByBookId(book.getId());
        String[] arr = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            arr[i] = Integer.toString(temp.get(i).getGenreId());
        }
        for (String string : arr) {
            List<Book> b = getBookByGenreId(string);
            Collections.shuffle(b);
            for (Book o1 : b) {
                if (!isDuplicate(a, o1.getId())) {
                    a.add(o1);
                }
            }
        }
        Book remove = null;
        for (Book o : a) {
            if (o.getId().equals(book.getId())) {
                remove = o;
            }
        }
        a.remove(remove);
        if (a.size() < 4) {
            return a;
        }
        return a.subList(0, 4);
    }

    public List<Book> getSearchBook(String input) {
        List<Book> list = new ArrayList<>();
        xSql = "select * from Book where LOWER(name) like ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + input + "%");
            rs = ps.executeQuery();
            String id, name, image, authorId, publisherId, description;
            float price;
            Book book;
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                image = rs.getString("image");
                authorId = rs.getString("authorId");
                publisherId = rs.getString("publisherId");
                description = rs.getString("description");
                price = rs.getFloat("price");
                book = new Book(id, name, image, authorId, publisherId, description, price);
                list.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public void deleteBook(String id) {
        xSql = "delete from Book where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editBook(String xId, String xName, String authorId, String description, float price) {
        xSql = "update Book set [name] = ?, [authorId] = ?, [description] = ?, [price] = ? where [id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xName);
            ps.setString(2, authorId);
            ps.setString(3, description);
            ps.setFloat(4, price);
            ps.setString(5, xId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook(String xId, String xName, String authorId, String description, float price) {
        xSql = "INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES (?,?,?,?,NULL,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xId);
            ps.setString(2, xName);
            ps.setString(3, xId + ".png");
            ps.setString(4, authorId);
            ps.setString(5, description);
            ps.setFloat(6, price);
            ps.executeQuery();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
