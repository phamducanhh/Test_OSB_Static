/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Book implements Comparable<Book>{
    private String id;
    private String name;
    private String image;
    private String authorId;
    private String publisherId;
    private String description;
    private float price;

    public Book() {
    }

    public Book(String id, String name, String image, String authorId, String publisherId, String description, float price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return "./img/"+image;
    }

    public String getImage1() {
        return "./img/1_"+image;
    }
    
    public String getImage2() {
        return "./img/2_"+image;
    }
    
    public String getImage3() {
        return "./img/3_"+image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return String.format("%.2f", this.price);
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", image=" + image + ", authorId=" + authorId + ", publisherId=" + publisherId + ", description=" + description + ", price=" + price + '}';
    }

    @Override
    public int compareTo(Book o) {
        if(o.price>this.price) return 1;
        return -1;
    }
    
}
