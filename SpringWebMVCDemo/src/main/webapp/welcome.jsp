<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<a href="index.jsp">Home</a>
</div>
<div>
	<a href="profile">Profile</a>
</div>
<div>
	<a href="logout">Logout</a>
</div>

<h1>Greeting everyone!!</h1>
<p>Welcome ${sessionScope.email}</p>

</body>
</html>