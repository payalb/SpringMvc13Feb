<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Information</title>
</head>
<body>
<h4> Search Results:</h4>
<c:forEach items="${doctors}" var="doctor">
<c:out value="${doctor.id}"></c:out><br/>
<c:out value="${doctor.name}"></c:out><br/>
<c:out value="${doctor.specialization}"></c:out><br/>
</c:forEach>
</body>
</html>