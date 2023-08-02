package com.example.asm_nguyenhnpk02250.Model;

import java.util.Date;

public class Product {
    private Integer ISBN, Publishers_ID, Authors_ID, Price, Categorys_ID, Quantity;
    private String Name,Image,Title;
    private Date Year;

    public Product(Integer ISBN, Integer publishers_ID, Integer authors_ID, Integer price, Integer categorys_ID, Integer quantity, String name, String image, String title, Date year) {
        this.ISBN = ISBN;
        Publishers_ID = publishers_ID;
        Authors_ID = authors_ID;
        Price = price;
        Categorys_ID = categorys_ID;
        Quantity = quantity;
        Name = name;
        Image = image;
        Title = title;
        Year = year;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getPublishers_ID() {
        return Publishers_ID;
    }

    public void setPublishers_ID(Integer publishers_ID) {
        Publishers_ID = publishers_ID;
    }

    public Integer getAuthors_ID() {
        return Authors_ID;
    }

    public void setAuthors_ID(Integer authors_ID) {
        Authors_ID = authors_ID;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getCategorys_ID() {
        return Categorys_ID;
    }

    public void setCategorys_ID(Integer categorys_ID) {
        Categorys_ID = categorys_ID;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getYear() {
        return Year;
    }

    public void setYear(Date year) {
        Year = year;
    }
}
