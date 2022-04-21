<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import="com.cognizant.swiggydemo.entitites.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	List<?> orderList = (List<?>) request.getAttribute("partnerOrders");
	List<OrderData> list = new ArrayList<OrderData>();
	for(Object object: orderList)
	{
		 if (object instanceof OrderData) {
		        list.add((OrderData) object); // <-- add to temp
		    }
	}
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
				<li class="nav-item mr-4"><a class="nav-link" href="PartnerIndex">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link mr-4" href="OngoingOrder">Live Delivery</a></li>
				<li class="nav-item active"><a class="nav-link mr-4" href="#">History</a>
				</li>
				<li class="nav-item"><a class="nav-link mr-4" href="#">Logout</a>
				</li>
			</ul>
		</div>
	</nav>




	<!-- -------------------- Hotel Cards---------------------------------------------- -->

	<div class="container pt-5">

	<%
		if(list.isEmpty()) {
	%>
		<h1 class="text-center">No History</h1>
	<% } else { %>

		<h2 class="text-center">Orders History</h2>
		<table class="table table-bordered text-center">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Item</th>
					<th scope="col">Quantity</th>
					<th scope="col">Total Amount</th>
					<th scope="col">Pick Up Location</th>
					<th scope="col">Delivery Location</th>
				</tr>
			</thead>
			<tbody>

				<%
					for(OrderData order: list)
					{
						%>
						<tr>
						<td><%= order.getOrderDataId() %></td>
						<td><%= order.getItemName() %></td>
						<td><%= order.getTotalQuantity() %></td>
						<td><%= order.getTotalAmount() %></td>
						<td><%= order.getPickUpLocation() %></td>
						<td><%= order.getDeliveryLocation() %></td>
						</tr>
				<% 
					}
				%>
				
			</tbody>
		</table>
		<% } %>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"></script>
</body>
</html>