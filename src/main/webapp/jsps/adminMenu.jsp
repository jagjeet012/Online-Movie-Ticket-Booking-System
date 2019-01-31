<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Movie Ticket Booking System</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<form action="addMovie" method="post">
		<h1 style="text-align: center; text-decoration: underline;">Admin
			View</h1>
		<pre>
		
Add Movie:     <input type="text" name="movieName"><br />
Add Movie Date:<input type="text" name="movieDate"><br />

<div style="text-align: left;">
		<a class="btn btn-default" href="/showMovie">List of Movies</a>
			</div>
	
<input type="submit" value="Submit">
		
		</pre>
	</form>

</body>
</html>