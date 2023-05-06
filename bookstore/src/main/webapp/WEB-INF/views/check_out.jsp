<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.book.models.*" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Check Out</title>
</head>
<body style="width:95%;margin-left:auto;margin-right:auto;">
	<h1>Book Shop Basket</h1>
	<nav style="display:flex; flex-direction:row; justify-content:space-between;">
		<a href="/">Back to home</a>
	</nav>
	<table style="width:95%;margin-left:auto;margin-right:auto;">
		<tr>
			<th>Book</th>
			<th>Author</th>
			<th>Price</th>
			<th>Quantity</th>
			<th></th>
		</tr>
		<%	Basket basket = (Basket) request.getSession().getAttribute("basket");

		if (basket != null) {
			Map<Book, Integer> basketBooks = basket.getBasket();
			for(Map.Entry<Book, Integer> book: basketBooks.entrySet()) {
				Book b = book.getKey();
				%>
				<tr>
					<td><%= b.getName() %></td>
					<td><%= b.getAuthor()%></td>
					<td><%= b.getPrice() %></td>
					<td><%= book.getValue() %></td>
					<td>
						<form method="POST"> 
							<input type="text" name="isbn" value="<%= b.getId() %>" style="display:none">
							<input type="submit" name="remove_from_cart" value="Remove">
						</form>
					</td>
				</tr>
				<% }
			} %>
		</table>
		<h3>TOTAL</h3> <%= basket.calculateTotalPrice() %> <br>
		<h2>PAYMENT DETAILS</h2>
		<div style="display:flex; flex-direction:row;">
			<form method="POST">
				Name on Card <input type="text" name="card_name"><br>
				<br>Card Number <input type="text" name="card_no"><br>
				<br>CVC <input type="text" name="cvc"><br>
				<h3>Shipping Details</h3>
				<% if(request.getSession().getAttribute("user") != null) {
					User user = (User) request.getSession().getAttribute("user"); %>
					<br>First Name <input type="text" name="f_name" value="<%= user.getFirstName() %>"><br>
					<br>Last Name <input type="text" name="l_name" value="<%= user.getLastName() %>"><br>
					<br>Address <input type="text" name="address" value="<%= user.getAddress() %>"><br>
					<br>Email <input type="text" name="email" value="<%= user.getEmail() %>"><br>
					<% } %>
					<br><input type="submit" name="pay" value="Make Payment"></br>
					</form>
				</div>
			</body>
			</html>
