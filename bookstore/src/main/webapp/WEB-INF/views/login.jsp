<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Login</title>
	<style>
		div {
			padding-top: 50px;
			padding-right: 50px;
			padding-bottom: 50px;
			padding-left: 50px;
		}
	</style>
</head>
<body style="width:95%;margin-left:auto;margin-right:auto;">
	<h1>Book Shop Login</h1>
	<nav style="display:flex; flex-direction:row; justify-content:space-between;">
		<a href="/">Back to home</a>
	</nav>
	<div style="flex-direction:column; justify-content:center; align-items: center;">
		<form method="POST">
			Username  <input type="text" name="user"/><br>
			Password <input type="password" name="pass"/><br>
			<input type="submit" name="login" value="Login"/>
		</form>
		Not registered? <a href="/reg">Click here.</a>
	</div>
	
</body>
</html>