<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" errorPage="error"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<core:forEach items="${products}" var="product">
		<core:out value="${product.productName}"></core:out>
		<core:out value="${product.price}"></core:out>
		<core:out value="${product.description}"></core:out>
		<core:out value="${product.category}"></core:out>
		<core:out value="${product.productId}"></core:out>
	</core:forEach>
</body>
</html>