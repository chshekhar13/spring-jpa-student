<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form method="post" action="addStudent.do" modelAttribute="addForm">
	<label>Enter Student ID</label>
	<f:input path="studentId"/><br>
	<f:errors path="studentId"/><br>
	<label>Enter Student Name</label>
	<f:input path="studentName"/><br>
	<f:errors path="studentName"/><br>
	<label>Enter Student Score</label>
	<f:input path="studentScore"/><br>
	<f:errors path="studentScore"/><br>
	<input type="submit" value="Save Data">
</f:form>
<jsp:include page="viewStudents.jsp"></jsp:include>
</body>
</html>