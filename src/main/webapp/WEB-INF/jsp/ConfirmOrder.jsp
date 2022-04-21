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

	<%
		Integer amount = (Integer) request.getAttribute("amount");
	Integer quantity = (Integer) request.getAttribute("quantity");
	String address = (String) request.getAttribute("address");
	%>


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
				<li class="nav-item active mr-4"><a class="nav-link" href="UserIndex">Home</a>
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
	<!-- 
	<div class="jumbotron py-5">
		<div class="container text-center">
			<h1 class="display-4">Hotel ABC</h1>
			<p class="lead">Confirm your order here !!!</p>
		</div>
	</div>
 -->






	<!-- --------------------- order model ---------------------------------------- -->

	<div class="container pt-3">
		<div class="row">
			<div class="col-md-6 offset-3">
				<div class="card bg-light p-3">
					<h3 class="text-center">Confirm Order</h3>
					<img src="/images/food.jpg" class="rounded mx-auto d-block"
						alt="Hotel Image">
					<h3 class="text-center">Biryani</h3>

					<!-- ---------------------- Order Form -------------------------------- -->

					<form action="PlaceOrderFromUser" method="POST">

						<input type="hidden" id="itemName" name="itemName" value="Biryani"
							required>

						<div class="form-group">
							<label for="quantity">Quantity</label> <input type="number"
								class="form-control" id="totalQuantity" name="totalQuantity"
								value=<%=quantity%> readonly>
						</div>
						<input type="hidden" id="pickUpLocation" name="pickUpLocation"
							value="Hotel ABC" required>
						<div class="form-group">
							<label for="address">Address</label>
							<textarea class="form-control" id="deliveryLocation"
								name="deliveryLocation" rows="3" readonly><%=address%></textarea>
						</div>
						<div class="form-group">
							<label for="amount">Total Amount</label> <input type="text"
								class="form-control" id="totalAmount" name="totalAmount"
								value=<%=amount%> readonly>
						</div>
						<input type="hidden" id="userSatus" name="userStatus"
							value="Placed"> <input type="hidden" id="hotelStatus"
							name="hotelStatus" value="Received" required> <input
							type="hidden" id="partnerStatus" name="partnerStatus"
							value="Received" required>

						<div class="text-center">
							<button type="submit" data-toggle="modal"
								data-target="#PlaceOrder" class="btn btn-primary">Place
								Order</button>
						</div>

					</form>
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