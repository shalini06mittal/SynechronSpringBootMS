<!--  directives -->
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
	color:red;
	}
</style>
</head>
<body>

<div>
	<a href="index.jsp">Home</a>
</div>
<div>
	<a href="login">Login</a>
</div>
<div>
	<a href="register">register</a>
</div>
	<h1>Please REGISTER</h1>
	<c:if test="${error != null}">
		<p class='error'>${error }</p>
	</c:if>
	<form action="register" method="POST">
		<div>
			Email : <input type='text' name="email" />
		</div>
		<div>
			Password : <input type='password' name="password" />
		</div>
		<div>
			FirstName : <input type='text' name=firstname />
		</div>
		<div>
			LastName : <input type='text' name="lastname" />
		</div>
		<div>
			City : <input type='text' name="city" />
		</div>
		<div>
			Country : <input type='text' name="country" />
		</div>
		<div>
			Phone : <input type='text' name="phone" />
		</div>
		
		<div>
			<input type='submit' value='Register' />
		</div>
	</form>
</body>
</html>