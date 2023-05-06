package com.book.util;

import com.book.daos.*;
import com.book.services.*;
/**
* Factory class, Unused
* @author Octavian Ionescu
*/
public class BISFactory {
	public static BookService getBookServiceObject() {
		
		return new BookServiceImpl(getBookDAOObject());
	}
	
	
	public static BookDAO getBookDAOObject() {
		return new BookDAOImpl();
	}
}
