<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Logout </title>
</head>
<body>
<%
session.removeAttribute("empId");
session.invalidate();
%>

<h1> Logged out successfully </h1>
<a href = "index.jsp"> Login again </a>

</body>
</html>