<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Register page </title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="wrapper">
	
		<form action = "Register" method = "post" class="login-register-form">
			<h2 align="center"> Register here </h2>
			<div class="container">
		
				<label> <b> Employee Id </b> </label>
				<input type="text" name="empId" placeholder="Enter Employee Id"> <br>
				
				<label> <b> Employee Name </b> </label>
				<input type="text" name="empName" placeholder="Enter Employee name"> <br>
				
				<label> <b> Employee email </b> </label>
				<input type="email" name = "empEmail" placeholder="Enter Email id"> <br>
				
				<input type="submit" value="Register" class = "submit-button"> <br>
				<input type="reset" value="Reset" class = "reset-button">
				
				<a href="index.jsp"> Already registered? </a>
			
			</div>
			
		</form>
	</div>
</body>
</html>