<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.book.models.User" %>
<%@ page import="com.book.models.Order" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Personal Details</title>
</head>
<body style="width:95%;margin-left:auto;margin-right:auto;">
	<h1>Book Shop Personal Details</h1>
	<nav style="display:flex; flex-direction:row; justify-content:space-between;">
		<a href="/">Back to home</a>
		<a href="/ch">Edit Personal Details</a>
	</nav>
	<div> <% User user = (User) request.getSession().getAttribute("user"); %>
		<br>First Name: <%= user.getFirstName() %></br>
		<br>Last Name: <%= user.getLastName() %></br>
		<br>Address: <%= user.getAddress() %></br>
		<br>Email: <%= user.getEmail() %></br>
	</div>
	<h2>PAST ORDERS</h2>
	<table style="width:95%;margin-left:auto;margin-right:auto;">
		<tr>
			<th>Order id</th>
			<th>Order Date</th>
			<th>Price</th>
		</tr>
		<%	List<Order> orders = (List<Order>) request.getSession().getAttribute("orderList");
			for(Order o: orders) {
				%>
				<tr>
					<td><%= o.getOrderID() %></td>
					<td><%= o.getOrderDate().toString() %></td>
					<td><%= o.getTotalPrice() %></td>
				</tr>
				<% } %>
				
			</table>
			
		</body>
		</html>