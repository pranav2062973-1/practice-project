<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="ErrorPage.jsp" %>
<%@ page import="com.cognizant.swiggydemo.entitites.UserRegister" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>

	<!-- ----------------navbar ------------------------------------------ -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand ml-5" href="#">Swigato</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto mr-5">
				<li class="nav-item active mr-4"><a class="nav-link" href="#">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link mr-4" href="UserTrackOrder">Track Order</a>
				</li>
				<li class="nav-item"><a class="nav-link mr-4" href="UserOrderHistory">History</a>
				</li>
				<li class="nav-item"><a class="nav-link mr-4" href="#">Logout</a>
				</li>
			</ul>
		</div>
	</nav>


	<!-- -----------------------User Index Banner    ------------------------------ -->

	<div class="jumbotron py-5">
		<div class="container text-center">
			<h1 class="display-4">Welcome, user</h1>
			<p class="lead">Order from below hotels ....</p>
		</div>
	</div>




	<!-- -------------------- Hotel Cards---------------------------------------------- -->

	<div class="container">
		<div class="row">


			<div class="col-sm-4">
				<div class="card">
					<img src="/images/hotel.jpg" class="card-img-top" height="200px"  alt="Hotel Image">
					<div class="card-body text-center">
						<h5>Hotel ABC</h5>
						<a href="/HotelMenu" class="btn btn-primary">View Menu</a>
					</div>
				</div>
			</div>
			
			
			<div class="col-sm-4">
				<div class="card">
					<img src="/images/hotel.jpg" class="card-img-top" height="200px" alt="Hotel Image">
				<div class="card-body text-center">
						<h5>Hotel PQR</h5>
						<a href="/HotelMenu" class="btn btn-primary">View Menu</a>
					</div>
				</div>
			</div>
			
			
			<div class="col-sm-4">
				<div class="card">
					<img src="/images/hotel.jpg" class="card-img-top" height="200px" alt="Hotel Image">
					<div class="card-body text-center">
						<h5>Hotel XYZ</h5>
						<a href="HotelMenu" class="btn btn-primary">View Menu</a>
					</div>
				</div>
			</div>
			
			
			
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"></script>
</body>
</html>