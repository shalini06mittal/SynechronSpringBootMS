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
	<a href="welcome">Welcome</a>
</div>
<div>
	<a href="logout">Logout</a>
</div>
<h1>Profile Page</h1>
<p>Welcome ${email}</p>
<div>
	<h1>Profile Details</h1>
	<div>Firstname : ${customer.firstname}</div>
	<div>Last name : ${customer.lastname}</div>
	<div>email : ${customer.email}</div>
	<div>City : ${customer.city}</div>
</div>
</body>
</html>