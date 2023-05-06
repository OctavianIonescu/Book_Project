package com.book.models;

import java.sql.Timestamp;
/**
* Order Object Class, handles all order objects
* @author Octavian Ionescu
*/
public class Order {
    private int orderID;
    private User user;
    private Timestamp orderDate;
    private double totalPrice;
    
    public Order(int orderID, User user, Timestamp orderDate, double totalPrice) {
        this.orderID = orderID;
        this.user = user;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }
    
    public int getOrderID() {
        return orderID;
    }
    
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Timestamp getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
