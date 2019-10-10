package com.example.youyi.sqlite;

public class Book {
    private String name;
    private String author;

    public Book(String name, String author, Double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
