<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./doctors.do" method="post">
Name: <input type="text" name="name"/><br/>
street: <input type="text" name="street"/><br/>
city: <input type="text" name="city"/><br/>
specialization: <input type="text" name="specialization"/><br/>
age: <input type="number" name="age"/><br/>
yearsOfExp: <input type="number" name="yearsOfExp"/><br/>
pincode: <input type="number" name="pincode"/><br/>
<input type="submit">
</form>
</body>
</html>