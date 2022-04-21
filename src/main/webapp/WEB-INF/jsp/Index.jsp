<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="ErrorPage.jsp" %>\

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

</head>
<body>



	<!-- -----------------------User Index Banner    ------------------------------ -->

	<div class="jumbotron py-5">
		<div class="container text-center">
			<h1 class="display-4">Welcome to Swigato</h1>
		</div>
	</div>




	<!-- -------------------- Hotel Cards---------------------------------------------- -->

	<div class="container">
		<div class="row text-center">


			<div class="col-sm-4">
				<div class="card">
				<img src="/images/food.jpg" class="card-img-top"
						alt="Hotel Image">
					<div class="card-body">
						<a href="UserHome" class="btn btn-primary">&nbsp; User &nbsp;</a>
					</div>
				</div>
			</div>


			<div class="col-sm-4">
				<div class="card">
				<img src="/images/food.jpg" class="card-img-top"
						alt="Hotel Image">
					<div class="card-body">
						<a href="HotelHome" class="btn btn-primary">&nbsp; Hotel &nbsp;</a>
					</div>
				</div>
			</div>



			<div class="col-sm-4">
				<div class="card">
				<img src="/images/food.jpg" class="card-img-top"
						alt="Hotel Image">
					<div class="card-body">
						<a href="PartnerHome" class="btn btn-primary">Partner</a>
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