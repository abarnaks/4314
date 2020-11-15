<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheeet" type="text/css" href="resources/static/css/main.css">

<!-- Static content -->


<script>

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
	  
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="#">Campus Checkin</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
			  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			      <li class="nav-item">
			        <a class="nav-link" href="/signup">Create account</a>
			      </li>
			      <li class="nav-item active">
			        <a class="nav-link" href="/">Login <span class="sr-only">(current)</span></a>
			      </li>
			    </ul>
			   
			  </div>
			</nav>
		
			<div class="m-5 pb-5">
				<section class="container-fluid">
					<section class="row justify-content-center">
						<section class="col-12 col-sm-6 col-md-3">		
								    
								    <form  action="login" method="post" onsubmit="return validate()">
								         
										      <div class="form-group">
											    <label for="name">Username</label>
											    <input class="form-control" name="name" id="name" aria-describedby="emailHelp" placeholder="Username">
											  </div>
											  
											  <div class="form-group">
											    <label for="name">Password</label>
											    <input class="form-control" name="pass" id="pass" type="password" aria-describedby="emailHelp" placeholder="Password">
											  </div>
											  
											  <div class="form-group">
											    <input type="submit" value="Submit">
										      </div>
								      
									    	  <p>Don't have an account? <a href="/signup">Sign up!</a></p>
									    	  
									    	  <p>${error_msg}</p>
									   
									   </form>
									   
					     </section>
					   </section>
				   
			  </section>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>