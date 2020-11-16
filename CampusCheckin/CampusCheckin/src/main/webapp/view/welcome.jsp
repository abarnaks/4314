<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheeet" type="text/css"
	href="resources/static/css/main.css">

	<!-- Static content -->
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Campus Checkin</a>
		 
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="/welcome">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/booking">Book now</a></li>		
				<li class="nav-item"><a class="nav-link" href="/">View booking</a></li>	
				<li class="nav-item">
		         <a class="nav-link" href="/login">Logout</a>
		        </li>
			</ul>
			<span class="navbar-text">Welcome to campus checkin, ${name}!</span>

		</div>
	</nav>

	<div class="m-5 pb-5">
		<section class="container-fluid">
			<section class="row justify-content-center">
				<section class="col-12 col-sm-10 col-md-6">

					<div id="accordion">
						<div class="card">
							<div class="card-header" id="headingOne">
								<h5 class="mb-0">
									<button class="btn btn-link" data-toggle="collapse"
										data-target="#collapseOne" aria-expanded="true"
										aria-controls="collapseOne">Find Building</button>
								</h5>
							</div>

							<div id="collapseOne" class="collapse show"
								aria-labelledby="headingOne" data-parent="#accordion">
								<div class="card-body">
									<div class="list-group">
									  <a href="getroom/${building1}" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
									    ${building1} <span class="badge badge-primary badge-pill">50 / ${building1_cap}</span>
									  </a>
									  <a href="getroom/${building2}" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
									  	 ${building2} <span class="badge badge-primary badge-pill">${building2_cap}</span>
									  </a>
									  <a href="getroom/${building3}" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
									  	 ${building3} <span class="badge badge-primary badge-pill">${building3_cap}</span>
									  </a>
									  <a href="getroom/${building4}" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
									  	 ${building4} <span class="badge badge-primary badge-pill">${building4_cap}</span>
									  </a>
					
									</div>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingTwo">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed" data-toggle="collapse"
										data-target="#collapseTwo" aria-expanded="false"
										aria-controls="collapseTwo">Covid Updates</button>
								</h5>
							</div>
							<div id="collapseTwo" class="collapse"
								aria-labelledby="headingTwo" data-parent="#accordion">
								<div class="card-body"> To find out more information about York University's response to Covid-19 <a href="https://yubettertogether.info.yorku.ca/important-links-resources/">Click here!</a></div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingThree">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed" data-toggle="collapse"
										data-target="#collapseThree" aria-expanded="false"
										aria-controls="collapseThree">View My Bookings</button>
								</h5>
							</div>
							<div id="collapseThree" class="collapse"
								aria-labelledby="headingThree" data-parent="#accordion">
								<div class="card-body">
									<a href="/booking" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
									     Booking 1 <span class="badge badge-primary badge-pill"></span>
									  </a>
									  <a href="/booking" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
									  	 Booking 2 <span class="badge badge-primary badge-pill"></span>
									  </a>
									  <a href="/booking" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
									  	 Booking 3 <span class="badge badge-primary badge-pill"></span>
									  </a>
			
								</div>
							</div>
						</div>
					</div>


				</section>
			</section>

		</section>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>