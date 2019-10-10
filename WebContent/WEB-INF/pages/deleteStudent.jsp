<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Student</title>
</head>
<body>
<f:form action="deleteStudent.do" method="post" modelAttribute="deleteForm">
		<label>Student ID</label>
		<f:input type="text" path="studentId"/><br>
		<f:errors path="studentId"/><br>
		<input type="submit" value="Delete Data"><br>
		
</f:form>
</body>
</html>