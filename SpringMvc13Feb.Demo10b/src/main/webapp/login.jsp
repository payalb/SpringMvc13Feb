<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>

<form action="./login"  method="post">
${param.error}
<sec:csrfInput/>
<c:if test="${param.error}">
<c:out value="Invalid username and Password!"></c:out>
</c:if>
<c:if test="${param.logout}">
<c:out value="Please login again. You have been logged out!"></c:out>
</c:if>
Username <input type="text" name="username" id="username"/><br/>
Password <input type="password" name="pswd" id="pswd"/><br/>
<input type="submit"/>
</form>
</body>
</html>