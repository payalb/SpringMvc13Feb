<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.error {
	color: red;
}
</style>
<title>
<spring:message code="login.heading"/>
</title>
</head>
<body>
	<form action="./validate.do" method="post">
	<a href="./login.do?language=zh">Chinese</a>
	<a href="./login.do?language=en">English</a>
		<h2 class="error">${message}</h2>
		<spring:message code="id"/> <input type="text" name="id" required><br />
		Password: <input type="password" name="password" required /><br /> <input
			type="submit">
	</form>
</body>
</html>