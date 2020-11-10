<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/static/css/main.css">
<script type="text/javascript" src="/resources/static/js/main.js"></script>

<title>Welcome to CampusCheckin</title>
</head>
<body>

	<h1>Spring Boot - MVC web application example</h1>
	<hr>
	
	<div class="form">
	  <form action="booking" method="post" onsubmit="return validate()">
	    <table>
	      <tr>
	        <td>Enter your username: </td>
	        <td><input id="username" name="username"></td>
	      </tr> 
	        
	      <tr>
	        <td>Enter your password: </td>
	        <td><input id="password" name="password"></td>
	        <td><input type="submit" value="Submit"></td> 
	      </tr>
	    </table>
	  </form>
	</div>

</body>
</html>