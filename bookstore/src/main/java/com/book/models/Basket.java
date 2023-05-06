package com.book.models;

import java.util.HashMap;
import java.util.Map;
/**
* Basket Object Class, creates and handles basket objects
* @author Octavian Ionescu
*/
public class Basket {
	
	private Map<Book, Integer> basket = new HashMap<Book, Integer>();
	private double totalPrice = 0;
	private User user;
	
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Basket(User user) {
		this.user = user;	
	}
	
	public Map<Book, Integer> getBasket() {
		return basket;
	}
	
	public void add(Book b) {
		
		if(basket.containsKey(b)) {
			int quantity = basket.get(b);
			basket.put(b, quantity + 1);
		} else {
			basket.put(b, 1);
		}
		this.totalPrice = this.totalPrice + b.getPrice();
		
	}
	
	public void remove(Book b) {
		basket.remove(b);
	}
	
	public double getTotalPrice() {   
		return this.totalPrice;
	}
	
	public double calculateTotalPrice() {
		
		double total = 0;
		Book current;
		for(Map.Entry<Book, Integer> book: basket.entrySet()) {
			current = book.getKey();
			total += current.getPrice() * basket.get(current);
		}
		
		return total;
		
	}
	
}

