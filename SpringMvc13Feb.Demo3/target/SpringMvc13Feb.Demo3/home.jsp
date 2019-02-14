<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./addEmployee.do" method="post">
<h2> ${errorMessage}</h2>
Name: <input type="text" name="name" id="name">
Salary:  <input type="number" name="salary" id="salary">
Project Name: <input type="text" name="projectName" id="projectName">
Id: <input type="number" name="id" id="id" >
Date of Joining: <input type="date" required name="doj"> 
<!-- yyyy-MM-dd, it is the same format as LocalDate -->
<!-- If u set it as text, it will send it in format: dd-MM-yyyy -->
<input type="submit">
</form>
</body>
</html>