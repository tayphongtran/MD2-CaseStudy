package com.company.model;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private String nameCategory;
    private User user;

    public Category() {
    }

    public Category(int id, String nameCategory, User user) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.user = user;
    }

    public Category(int id, String nameCategory) {
        this.id = id;
        this.nameCategory =nameCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return  nameCategory +  " { " +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                ", user=" + user +"\n"+
                " } ";
    }
}
