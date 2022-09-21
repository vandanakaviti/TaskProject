<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Home </title>
<link type="text/css" rel="stylesheet" href="css/style.css" >
</head>
<body>
	
	<div id="clock" class="clock-class"></div>
	<div class="dashboard">
	<h2> Dashboard </h2>
	</div>
	
	<h2 style="color:green; text-align:center;"> Login Successful </h2>
	<h2> Welcome, <%=session.getAttribute("empName") %>! </h2>
	
	<form action="ViewAllUsers" method="get" class="main-page-form">
		<input type="submit" value="View User details" class="center-button">
	</form>
	
	<form action="Logout" method="post" class="main-page-form">
		<input type="submit" value="Logout" class="logout-button">
	</form>
	
	<script type="text/javascript">
	    var clock = document.getElementById('clock');
	    function displayClock() {
	        clock.textContent = new Date().toString();
	    }
	    setInterval(displayClock, 1000);
	</script>
	
</body>
</html>