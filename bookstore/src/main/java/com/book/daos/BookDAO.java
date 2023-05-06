package com.book.daos;

import java.util.List;

import com.book.models.Basket;
import com.book.models.Book;
import com.book.models.Order;
import com.book.models.User;
/**
* BookDAO interface, declares methods to be used
* @author Octavian Ionescu
*/
public interface BookDAO {
    public int addUser(User user);
    public User userLogin(String userEmail, String userPassword);
    public List<Book> listAllBooks();
    public List<Book> findAllBooksByName(String Name);
    public List<Order> listAllOrdersByUser(User user);
    public int updateUserEmailByUser(User user, String newEmail);
    public int updateUserAddressByUser(User user, String newAddress);
    public int updateUserFirstNameByUser(User user, String newFirstName);
    public int updateUserLastNameByUser(User user, String newLastName);
    public int updateUserPasswordByUser(User user, String newPassword);
    public int placeOrder(Basket basket);
    
    
}
