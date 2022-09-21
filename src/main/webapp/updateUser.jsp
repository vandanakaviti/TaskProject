<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Update Page </title>
<link type="text/css" rel="stylesheet" href ="css/style.css">
</head>
<body>
		<form action = "Update" method="post">
			<div class = "container">
				<label> Enter the updated Employee name </label>
				<input type="text" name = "updatedName" placeholder="Enter employee name"><br>
				
				<input type="submit" value="Update" class = "update-button">
			</div>
		</form>
</body>
</html>