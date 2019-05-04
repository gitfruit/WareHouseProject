<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>Welcome to ShipmentType View Page</h2>
			</div>

			<div class="card-body">
				<table class="table table-striped table-bordered">
						<tr>
							<th>ID</th>
							<td>${st.shipmentId}</td>
						</tr>
						<tr>
							<th>MODE</th>
							<td>${st.shipmentMode}</td>
						</tr>
						<tr>
							<th>CODE</th>
							<td>${st.shipmentCode}</td>
						</tr>
						<tr>
							<th>ENABLED</th>
							<td>${st.shipmentEnable}</td>
						</tr>
						<tr>
							<th>GRADE</th>
							<td>${st.shipmentGrade}</td>
						</tr>
						<tr>
							<th>NOTE</th>
							<td>${st.snote}</td>
						</tr>
				</table>
			</div>
	</div>
<!--card ends-->	
</div>
           <!-- container ends -->
</body>
</html>