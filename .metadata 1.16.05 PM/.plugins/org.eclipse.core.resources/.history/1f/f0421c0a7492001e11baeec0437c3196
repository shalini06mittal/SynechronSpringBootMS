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

	<h1>Please Login</h1>
	<c:if test="${error != null}">
		<p class='error'>${error }</p>
	</c:if>
	<form action="login" method="POST">
		<div>
			Email : <input type='text' name="email" />
		</div>
		<div>
			Password : <input type='password' name="password" />
		</div>
		<div>
			Password : <input type='number' name="age" />
		</div>
		<div>
		<%-- ${roles[1] } --%>
			<select name="role">
				<c:forEach items="${roles }" var="role">
					<option>${role }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<input type='submit' value='Login' />
		</div>
	</form>
</body>
</html>