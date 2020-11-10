<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->


<script>

function postUsers() {
	var name = document.getElementById("name").value;
	var studentID = document.getElementById("studid").value;
	var email = document.getElementById("em").value;
	var password = document.getElementById("pass").value;
	fetch('/users' , {method: 'POST', body: {
		
		
		"name":"Lecture Hall A",
		 "studentID": "20",
		 "email": "1",
		 "password":"123"


		}})
		.then(results => results).then(console.log)
}

function test() {
	console.log("working")
}

function validate() {
	var name = document.getElementById("name").value;
	var studentID = document.getElementById("studid").value;
	var email = document.getElementById("em").value;
	var password = document.getElementById("pass").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} else if (studentID == '') {
		alert('Please enter a valid studentID.');
		return false;
	} else if (email == '') {
		alert('Please enter a valid email.');
		return false;
	}
	else if (password == '') {
		alert('Please enter a valid password.');
		return false;
	}
	else {
		return true;
	}
	
	
}

</script>

<title>Spring Boot</title>
</head>
<body>
  <h1>Spring Boot - MVC web application example</h1>
  <hr>
  <div class="form">
    <form action="users" method="post" onsubmit="return validate()">
      <table>
        <tr>
          <td>Enter Your username</td>
          <td><input id="name" name="name"></td>
          <tr></tr>
          <td>Enter Your password</td>
          <td><input type="password" id="pass" name="pass"></td> 
           <tr></tr>
          <td><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </form>
    <p>Don't have an account...<a href="/signup">Sign up here!</a></p>
  </div>

</body>
</html>