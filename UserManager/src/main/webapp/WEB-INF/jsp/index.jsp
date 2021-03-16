<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Spring App</title>
</head>
<body>
	<h2>Search or List</h2><br>
	<a href="users">List all users</a><br><br>
	<form action="/edituser" method="POST">
			<label for="id">Enter ID:</label>
			<input type="text" placeholder="ID" id="id" name="id"><br><br> 
			<br> <input type="submit" value="Search"><br><br>
	</form>
</body>
</html>