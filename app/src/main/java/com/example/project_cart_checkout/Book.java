package com.example.project_cart_checkout;

public class Book {

    private String title, price;
    private int coverId;

    public Book() {
    }

    public Book(String title, String price, int coverId) {
        this.title = title;
        this.price = price;
        this.coverId = coverId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCoverId() {
        return coverId;
    }

    public void setCoverId(int coverId) {
        this.coverId = coverId;
    }
}
