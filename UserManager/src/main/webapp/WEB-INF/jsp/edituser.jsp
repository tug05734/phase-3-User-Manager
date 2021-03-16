<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Spring App</title>
</head>
<body>
	<h2>Edit User</h2>
	<table>
		<tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
		<c:forEach items="${users}" var="user" varStatus="count">
			<tr id="${count.index}">
				<td>${user.id}</td>
				<td style="padding:0 30px 0 30px;">${user.name}</td>
				<td style="padding:0 30px 0 30px;">${user.email}</td>
				<td style="padding:0 30px 0 30px;">${user.password}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<form action="/process_update" method="POST">
			<label for="name">Edit Name:</label>
			<input type="text" placeholder="Name" id="name" name="name"><br><br> 
			<label for="email">Edit E-mail:</label>
			<input type="text" placeholder="Email" id="email" name="email"><br><br> 
			<label for="password">Enter Password:</label>
			<input type="password" placeholder="Password" id="password" name="password"><br><br> 
			<br> <input type="submit" value="Update"><br><br>
	</form>
</body>
</html>