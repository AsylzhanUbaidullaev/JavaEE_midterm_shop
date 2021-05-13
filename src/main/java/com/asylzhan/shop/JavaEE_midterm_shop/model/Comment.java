package com.asylzhan.shop.JavaEE_midterm_shop.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int id;
    private String comment;
    private int product_id;
    private int userid;
    private User user;

    public Comment() {
    }

    public Comment(int id, String comment, int product_id, int userid, User user) {
        this.id = id;
        this.comment = comment;
        this.product_id = product_id;
        this.userid = userid;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
