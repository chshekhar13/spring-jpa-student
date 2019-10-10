<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Students</title>
</head>
<body>
	<!-- <c:out value="${ requestScope.model }"/> -->
	
	<table>
		<tr>
			<th>Student Id</th>
			<th>Student Name</th>
			<th>Student Score</th>
			
		</tr>
		<c:forEach var="student" items="${studentList}">
			<tr>
				<td>${student.studentId}</td>
				<td>${student.studentName}</td>
				<td>${student.studentScore}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>