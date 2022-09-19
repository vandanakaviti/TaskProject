<%@page import="com.dao.RegisterDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Logout page </title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="text-align: center">
	<%
	session.removeAttribute("username");
	session.invalidate();
	%>

	<h1 style="color: green">Logged out successfully</h1>
	<a href="index.jsp"> Login again </a>
</body>
</html>