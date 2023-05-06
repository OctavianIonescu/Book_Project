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
	<title>Edit Profile</title>
</head>
<body style="width:95%;margin-left:auto;margin-right:auto;">
	<h1>Book Shop Personal Details Edit</h1>
	<nav style="display:flex; flex-direction:row; justify-content:space-between;">
		<a href="/">Back to home</a>
	</nav>
	<div style="flex-direction:column; justify-content:center; align-items: center;">
		<form method="POST">
			<div> <% User user = (User) request.getSession().getAttribute("user"); %>
                <br>First Name: <%= user.getFirstName() %></br> Change Firstname  <input type="text" name="firstName"/><br>
                <br>Last Name: <%= user.getLastName() %></br> Change Lastname  <input type="text" name="lastName"/><br>
                <br>Address: <%= user.getAddress() %></br> Change Address <input type="text" name="address"/><br>
                <br>Email: <%= user.getEmail() %></br> Change Email  <input type="text" name="email"/><br>
                <br>Change Password <input type="password" name="pass"/><br>
                <br><input type="submit" name="saveChanges" value="Save Changes"/>
            </div>
		</form>
	</div>
</body>
</html>