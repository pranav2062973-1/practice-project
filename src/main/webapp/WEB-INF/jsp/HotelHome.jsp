<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ page errorPage="ErrorPage.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>


	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-4">Hotel - Home Page</h1>
			<p class="lead">This is Home Page for Hotel to register/login into system.</p>
		</div>
	</div>

	<div class="container text-center">
		<button type="button" class="btn btn-primary btn-lg px-4"
			data-toggle="modal" data-target="#LoginModal">&nbsp; Login
			&nbsp;</button>
		<button type="button" class="btn btn-outline-primary btn-lg px-4"
			data-toggle="modal" data-target="#RegisterModal">Register</button>
	</div>




	<!-- Login Modal -->
	<div class="modal fade" id="LoginModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Login Here !!!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<!-- ---------------------- Login Form -------------------------------- -->

					<form action="HotelLogin" method="POST">
						<div class="form-group">
							<label for="hotelEmail">Email address</label> <input
								type="email" class="form-control" id="hotelEmail" name="hotelEmail"
								aria-describedby="emailHelp" required>
						</div>
						<div class="form-group">
							<label for="hotelPassword">Password</label> <input name="hotelPassword"
								type="password" class="form-control" id="exampleInputPassword1" required>
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>





	<!-- Register Modal -->
	<div class="modal fade" id="RegisterModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Register Here !!!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<!-- ---------------------- Register Form -------------------------------- -->

					<form action="HotelRegister" method="POST">

						<div class="form-group">
							<label for="hotelName">Name</label> <input
								type="text" class="form-control" id="hotelName" name="hotelName"
								aria-describedby="emailHelp" required>
						</div>
						<div class="form-group">
							<label for="hotelEmail">Email address</label> <input
								type="email" class="form-control" id="hotelEmail" name="hotelEmail"
								aria-describedby="emailHelp" required>
						</div>
						<div class="form-group">
							<label for="hotelPassword">Password</label> <input name="hotelPassword"
								type="password" class="form-control" id="hotelPassword">
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
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