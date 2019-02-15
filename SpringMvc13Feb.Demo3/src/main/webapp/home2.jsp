<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<form:form action="./addEmployee.do" method="post"
		modelAttribute="employee">
		<form:errors path="*" cssClass="error"></form:errors>
		<%-- <form:errors path="name" /> --%>
Name: <form:input path="name" id="name"  cssErrorClass="error" type="text"/>
	<%-- 	<form:errors path="salary" /> --%>
Salary:  <form:input path="salary" id="salary"  cssErrorClass="error" type="number"/>
		<%-- <form:errors  path="projectName"></form:errors> --%>
Project Name: <form:input path="projectName" id="projectName" type="text" cssErrorClass="error"/>
		<%-- <form:errors  path="id"></form:errors> --%>
Id: <form:input path="id" id="id"  type="number" cssErrorClass="error"/>
		<%-- <form:errors path="doj"></form:errors> --%>
Date of Joining: <form:input path="doj" type="date" cssErrorClass="error"/> 
Checking update
<!-- yyyy-MM-dd, it is the same format as LocalDate -->
		<!-- If u set it as text, it will send it in format: dd-MM-yyyy -->
		<input type="submit">
	</form:form>
</body>
</html>