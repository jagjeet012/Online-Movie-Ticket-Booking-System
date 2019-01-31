<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Online Movie Ticket Booking System</title>
</head>
<body>
	<form action="saveTicket" method="post">
		<h1 style="text-align: center; text-decoration: underline;">User
			View</h1>
		<pre>
		
Select Movie:<input type="text" name="movieName"><br />
Select Date: <input type="text" name="movieDate"><br />
Select movie Time:<select name="movieTime">
	<option value="">-Select-</option>
	<option value="Morning">9am-12pm</option>
	<option value="Afternoon">12pm-3pm</option>
	<option value="Evening">3pm-6pm</option>
	<option value="Night">6pm-9pm</option>
	<option value="LateNight">9pm-12am</option>
	</select><br />
Select Number Of Seats: <input type="number" name="noOfSeats"><br />
<input type="submit" value="submit">
		
		</pre>
	</form>
</body>
</html>