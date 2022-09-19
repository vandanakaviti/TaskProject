<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href ="css/style.css">
</head>
<body>
		<form action = "Update" method="post">
			<div class = "container">
				<label> Enter the Employee id to update their profile </label>
				<input type="text" name = "empId" placeholder="Enter username"><br>
				
				<label> Enter the updated Employee name </label>
				<input type="text" name = "empName" placeholder="Enter username"><br>
				
				<input type="submit" value="Update" class = "submitbutton">
			</div>
		</form>
</body>
</html>