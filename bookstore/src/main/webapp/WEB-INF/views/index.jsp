<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.*"%>
<%@ page import="com.book.models.Book"%>
<%@ page import="com.book.models.Basket" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
</head>
<body style="width:95%;margin-left:auto;margin-right:auto;">
	<h1>Book Shop</h1>
	<nav style="display:flex; flex-direction:row; justify-content:space-between;">
		
		<% if(request.getSession().getAttribute("user") == null) { 
			//System.out.println(request.getSession().getAttribute("user"));	
			%>
			<a href="/login">Login</a>
			<a href="/login">Basket</a>
			<% } else if(request.getSession().getAttribute("user") != null) { 
				System.out.println(request.getSession().getAttribute("user"));		
				%>
				<a href="/logout">Logout</a>
				<a href="/pd">Personal Details</a>
				<a href="/co">Basket</a>	
				<% } %>
			</nav>
			<div>
				<form method="POST">
					<input type="text" name="book_search">
					<input type="submit" name="search" value="Search">
				</form>
			</div>
			<div>
				<table style="width:95%;margin-left:auto;margin-right:auto;">	
					<tbody>
						<tr>
							<th scope="col"> Book Name </th>
							<th scope="col"> Book Author  </th>
							<th scope="col"> Description  </th>
							<th scope="col"> Price </th>
							<th scope="col"> </th>			
						</tr>
						<% Map<Integer, Book> bookList = new HashMap<>();
						if(request.getAttribute("searchBookList") != null) {
							bookList =  (HashMap<Integer, Book>) request.getAttribute("searchBookList"); 
						} else {
							bookList =  (HashMap<Integer, Book>) request.getSession().getAttribute("bookList"); 
						}
						for(Map.Entry<Integer, Book> b  : bookList.entrySet()) {
							%>
							<tr>
								<td><%= b.getValue().getName() %></td>
								<td><%= b.getValue().getAuthor() %></td>
								<td><%= b.getValue().getOverview() %></td>
								<td><%= b.getValue().getPrice() %></td>
								<td>
									<form method="POST"> 
										<input type="text" name="id" value=<%= b.getValue().getId() %> style="display:none">
										<input type="submit" name="add_to_cart" value="Add to cart">
									</form>
								</td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>
			</body>
			</html>