package com.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection con;
	
	
	private DatabaseConnection() {
		
	}
	
	public static Connection getMyDBConnection() {
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			if(con == null ) 
			con = DriverManager.getConnection("jdbc:mysql://localhost/bookstore_db","root","manager");
			
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return con;
		
	}
}

