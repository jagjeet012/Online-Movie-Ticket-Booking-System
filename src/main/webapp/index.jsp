<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Movie Ticket Booking System</title>
</head>
<body>
	<form action="doLogin" method="get">
		<h1 style="text-align: center; text-decoration: underline;">Login
			Page</h1>
		<pre>
		
User Name:<input type="text" name="userName"><br />
Password: <input type="password" name="password"><br />
<input type="submit" value="Submit">
</pre>
	</form>
	<form action="doRegister" method="post">
		<input type="hidden" name="userName" value=""><br /> <input
			type="hidden" name="password" value=""><br /> <input
			type="submit" value="Register">
	</form>


</body>
</html>