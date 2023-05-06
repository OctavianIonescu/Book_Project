package com.book.models;
/**
* User Object Class, handles all User objects
* @author Octavian Ionescu
*/
public class User {
    
    private int u_ID;
    private String firstName, lastName, address, email, password;
    
    public User(String firstName, String lastName, String address, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    public User(int ID, String firstName, String lastName, String address, String email, String password) {
        this.u_ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    public int getU_ID() {
        return u_ID;
    }
    public void setU_ID(int u_ID) {
        this.u_ID = u_ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
