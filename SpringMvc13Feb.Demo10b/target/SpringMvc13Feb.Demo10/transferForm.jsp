<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
<form action="./transferMoney.htm" method="post">
<a href="./logout">Logout</a>
<h3 style="color:red">${errorMsg}</h3>
From account number: <input type="text" name="fromAccount.accountNumber"/><br/>
From bank: <input type="text" name="fromAccount.bank"/><br/>
To account number: <input type="text" name="toAccount.accountNumber"/><br/>
To Bank: <input type="text" name="toAccount.bank"/><br/>
Amount: <input type="number" name="amount"/><br/>
<input type="submit"/>
</form>
</body>
</html>