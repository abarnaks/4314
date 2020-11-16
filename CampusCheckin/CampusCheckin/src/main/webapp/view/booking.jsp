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

<meta charset="ISO-8859-1">
<title>View Rooms and Availability</title>
</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">Campus Checkin</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	      <li class="nav-item"><a class="nav-link" href="/welcome">Home</a></li>		      
	      <li class="nav-item active">
	        <a class="nav-link" href="/booking">Book now <span class="sr-only">(current)</span></a></li>
	      <li class="nav-item">
	        <a class="nav-link" href="/">View booking</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/login">Logout</a>
	      </li>
	    </ul>
	   
	  </div>
	</nav>
	
	
	<div class="m-5 pb-5">
				<section class="container-fluid">
					<section class="row justify-content-center">
						<section class="col-12 col-sm-6 col-md-6">		
						
							<form>
								 <div class="form-group">
								    <label for="exampleFormControlSelect1"><h4>Building: ${buildingName}</h4></label> 
								  </div>
								  
								  <div class="form-group">
								    <label><h4>Room: </h4></label>								   
								  </div>
								  
								  <div class="form-group">
								  	<label><h4>Date and Time: </h4></label>
								  </div>
								  
								  <div class="form-group">
								    <label><h4>Study Group Size: </h4></label>
								  </div>
	
								  <div class="form-group">
								    <input type="submit" value="Confirm">
							      </div>
								  
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