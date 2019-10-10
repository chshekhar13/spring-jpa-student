<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<f:form method="post" action="login.do" modelAttribute="loginForm">
	<label>Username</label>
	<f:input path="username"/><br>
	<f:errors path="username"/><br>
	<label>Password</label>
	<f:input type="password" path="password"/><br>
	<f:errors path="password"/><br>
	<input type="submit" value="Login">
</f:form>
</body>
</html>