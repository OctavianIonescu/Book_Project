package com.book.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.book.daos.BookDAO;
import com.book.models.Basket;
import com.book.models.Book;
import com.book.models.Order;
import com.book.models.User;
/**
* BookService Implementation
* @author Octavian Ionescu
*/
public class BookServiceImpl implements BookService {
	
	private BookDAO bookDAO;
	
	public BookServiceImpl(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	


	@Override
	public int addUser(User user) {
		return bookDAO.addUser(user);
	}
	


	@Override
	public User userLogin(String userEmail, String userPassword) {
		return bookDAO.userLogin(userEmail, userPassword);
	}
	


	@Override
	public List<Book> listAllBooks() {
		return bookDAO.listAllBooks();
	}
	


	@Override
	public Map<Integer, Book> mapIdToBooks(List<Book> books) {
		System.out.println("Booksize " + books.size());
		Map<Integer, Book> map = new HashMap<>();
		for(Book b: books) {
			System.out.println(b);
			map.put(b.getId(), b);
		}
		System.out.println("Map size " + map.size());
		return map;
	}
	


	@Override
	public List<Book> findAllBooksByName(String Name) {
		return bookDAO.findAllBooksByName(Name);
	}
	


	@Override
	public List<Order> listAllOrdersByUser(User user) {
		return bookDAO.listAllOrdersByUser(user);
	}
	


	@Override
	public int updateUserEmailByUser(User user, String newEmail) {
		return bookDAO.updateUserEmailByUser(user, newEmail);
	}
	


	@Override
	public int updateUserAddressByUser(User user, String newAddress) {
		return bookDAO.updateUserAddressByUser(user, newAddress);
	}
	


	@Override
	public int updateUserFirstNameByUser(User user, String newFirstName) {
		return bookDAO.updateUserFirstNameByUser(user, newFirstName);
	}
	


	@Override
	public int updateUserLastNameByUser(User user, String newLastName) {
		return bookDAO.updateUserLastNameByUser(user, newLastName);
	}
	


	@Override
	public int updateUserPasswordByUser(User user, String newPassword) {
		return bookDAO.updateUserPasswordByUser(user, newPassword);
	}
	

	
	@Override
	public int placeOrder(Basket basket, User user) {
		return bookDAO.placeOrder(basket);
	}
	
}
