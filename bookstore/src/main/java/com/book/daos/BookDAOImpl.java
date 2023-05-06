package com.book.daos;

import java.sql.*;
import java.util.*;

import com.book.models.*;
import com.book.util.DatabaseConnection;
/**
* BookDAO interface implementation
* @author Octavian
*/
public class BookDAOImpl implements BookDAO {
    
    private List<Book> bookList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    
    private Connection con = DatabaseConnection.getMyDBConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public int addUser(User user) {
        int i = 0;
        try {
            
            this.pst = this.con.prepareStatement("INSERT INTO User(first_name, last_name, user_address, email, user_password) VALUES (?, ?, ?, ?, ?);");
            
            
            this.pst.setString(1,user.getFirstName());
            this.pst.setString(2,user.getLastName());
            this.pst.setString(3,user.getAddress());
            this.pst.setString(4,user.getEmail());
            this.pst.setString(5,user.getPassword());
            
            
            i = this.pst.executeUpdate();
            
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return i;
        
        
    }
    


    @Override
    public User userLogin(String userEmail, String userPassword) {
        User e = null;
        
        try {
            
            this.pst = this.con.prepareStatement("SELECT * from User WHERE email = ? AND user_password = ?;");
            
            
            this.pst.setString(1, userEmail);
            this.pst.setString(2, userPassword);
            
            
            this.rs = this.pst.executeQuery();
            
            
            if(this.rs.next()) {
                e = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
            }
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        
        
        return e;
    }
    


    @Override
    public List<Book> listAllBooks() {
        try {
            
            this.pst = this.con.prepareStatement("SELECT * FROM book;");
            
            
            this.rs = this.pst.executeQuery();
            
            
            while(this.rs.next()) {
                
                Book n = new Book(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(4), this.rs.getString(5), this.rs.getDouble(6));
                bookList.add(n);
                
            }
            
            
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        
        
        
        return this.bookList;
    }
    


    @Override
    public List<Book> findAllBooksByName(String Name) {
        try {
            
            Name = "%" + Name + "%";
            
            this.pst = this.con.prepareStatement("SELECT * FROM book WHERE book_name LIKE ?;");
            
            this.pst.setString(1, Name);
            
            System.out.println(this.pst.toString());
            
            this.rs = this.pst.executeQuery();
            
            bookList.clear();
            
            while(this.rs.next()) {
                
                Book n = new Book(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(4), this.rs.getString(5), this.rs.getDouble(6));
                bookList.add(n);
                
            }   
        }
        catch(SQLException e){
            System.out.println(e);
        }  
        return this.bookList;
    }
    
    @Override
    public List<Order> listAllOrdersByUser(User user) {
        try {
            
            this.pst = this.con.prepareStatement("SELECT order_ID, order_date, total_price FROM placed_orders WHERE u_ID = ?;");
            System.out.println("userid " + user.getU_ID());
            this.pst.setInt(1, user.getU_ID());
            System.out.println(this.pst.toString());
            this.rs = this.pst.executeQuery();
            orderList.clear();
            while(this.rs.next()) {
                System.out.println("order item");
                Order ord = new Order(this.rs.getInt(1), user, this.rs.getTimestamp(2), this.rs.getDouble(3));
                orderList.add(ord);
            }  
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return this.orderList;
    }
    


    @Override
    public int updateUserEmailByUser(User user, String newEmail) {
        user.setEmail(newEmail);
        try{
            this.pst = this.con.prepareStatement("UPDATE user SET email = ? WHERE u_ID = ?;", Statement.RETURN_GENERATED_KEYS);
            this.pst.setInt(2, user.getU_ID());
            this.pst.setString(1, newEmail);
            this.pst.execute();
            return 1;
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    


    @Override
    public int updateUserAddressByUser(User user, String newAddress) {
        user.setAddress(newAddress);
        try{
            this.pst = this.con.prepareStatement("UPDATE user SET user_address = ? WHERE u_ID = ?;", Statement.RETURN_GENERATED_KEYS);
            this.pst.setInt(2, user.getU_ID());
            this.pst.setString(1, newAddress);
            this.pst.execute();
            return 1;
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    


    @Override
    public int updateUserFirstNameByUser(User user, String newFirstName) {
        user.setFirstName(newFirstName);
        try{
            this.pst = this.con.prepareStatement("UPDATE user SET first_name = ? WHERE u_ID = ?;", Statement.RETURN_GENERATED_KEYS);
            this.pst.setInt(2, user.getU_ID());
            this.pst.setString(1, newFirstName);
            this.pst.execute();
            return 1;
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    


    @Override
    public int updateUserLastNameByUser(User user, String newLastName) {
        user.setLastName(newLastName);
        try{
            this.pst = this.con.prepareStatement("UPDATE user SET last_name = ? WHERE u_ID = ?;", Statement.RETURN_GENERATED_KEYS);
            this.pst.setInt(2, user.getU_ID());
            this.pst.setString(1, newLastName);
            this.pst.execute();
            return 1;
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    


    @Override
    public int updateUserPasswordByUser(User user, String newPassword) {
        user.setPassword(newPassword);
        try{
            this.pst = this.con.prepareStatement("UPDATE user SET user_password = ? WHERE u_ID = ?;", Statement.RETURN_GENERATED_KEYS);
            this.pst.setInt(2, user.getU_ID());
            this.pst.setString(1, newPassword);
            this.pst.execute();
            return 1;
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    

    
    @Override
    public int placeOrder(Basket basket) {
        try{
            this.pst = this.con.prepareStatement("INSERT INTO placed_orders(u_id, total_price) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
            this.pst.setInt(1, basket.getUser().getU_ID());
            this.pst.setDouble(2, basket.getTotalPrice());
            System.out.println(this.pst.toString());
            this.pst.execute();
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                int ordID = rs.getInt(1);
                Map<Book, Integer> list = basket.getBasket();
                Set<Book> books = list.keySet();
                Iterator<Book> itr = books.iterator();
                while(itr.hasNext()){
                    Book b = itr.next();
                    this.pst = this.con.prepareStatement("INSERT INTO book_order(book_ID, order_ID, quantity) VALUES (?, ?, ?);",  Statement.RETURN_GENERATED_KEYS);
                    this.pst.setInt(1, b.getId());
                    this.pst.setInt(2, ordID);
                    this.pst.setInt(3, basket.getBasket().get(b));
                    System.out.println(this.pst.toString());
                    this.pst.execute();
                }
                
                return 1;
            }
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
        return 0;
    }
}

