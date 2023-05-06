package com.book.models;
/**
* Book Object Class, handles Book objects
* @author Octavian Ionescu
*/
public class Book {
    private int id;
    private double price;
    private String name, author, overview;
    
    public Book(String name, String author, String overview, double price) {
        this.price = price;
        this.name = name;
        this.author = author;
        this.overview = overview;
    }
    
    public Book(int id, String name, String overview, String author, double price) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.author = author;
        this.overview = overview;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
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
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    
}
