<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Login page </title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="wrapper">
	
		<form action = "Login" method = "post" class="login-register-form">
			<h2 align="center"> Login </h2>
			<div class="container">
		
				<label> <b> Employee Id </b> </label>
				<input type="text" name="empId" placeholder="Enter Employee Id"> <br>
				
				<label> <b> Employee Name </b> </label>
				<input type="text" name="empName" placeholder="Enter Employee name"> <br>
				
				<input type="submit" value="Login" class="submit-button"> <br>
				<input type="checkbox" value = "Remember password"> Remember password
				
				<a href="register.jsp"> New User? </a>
			
			</div>
			
		</form>
	</div>
</body>
</html>