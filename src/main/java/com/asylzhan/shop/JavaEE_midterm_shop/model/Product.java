package com.asylzhan.shop.JavaEE_midterm_shop.model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String name;
    private String description;
    private String imgLink;
    private String imgLink2;
    private String color;
    private double price;
    private List<Comment> commentList;

    public Product() {
    }

    public Product(int id, String name, String description, String imgLink, String imgLink2, String color, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgLink = imgLink;
        this.imgLink2 = imgLink2;
        this.color = color;
        this.price = price;
    }

    public Product(String name, String description, String color, double price) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.price = price;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getImgLink2() {
        return imgLink2;
    }

    public void setImgLink2(String imgLink2) {
        this.imgLink2 = imgLink2;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
