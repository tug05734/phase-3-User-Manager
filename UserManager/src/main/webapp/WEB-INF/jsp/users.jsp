<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
	<h2>Users</h2>
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
</body>
</html>