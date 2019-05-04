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
<h2>Welcome to WhUserType View Page</h2>
			</div>

			<div class="card-body">
				<table class="table table-striped table-bordered">
<tr>
<th>Id</th>
<td>${wh.userId}</td>
</tr>
<tr>
<th>Type</th>
<td>${wh.userType}</td>
</tr>
<tr>
<th>Code</th>
<td>${wh.userCode}</td>
</tr>
<tr>
<th>For</th>
<td>${wh.userFor}</td>
</tr>
<tr>
<th>Email</th>
<td>${wh.userEmail}</td>
</tr>
<tr>
<th>Contact</th>
<td>${wh.userContact}</td>
</tr>
<tr>
<th>IdType</th>
<td>${wh.userIDType}</td>
</tr>
<tr>
<th>IdNumber</th>
<td>${wh.idNumber}</td>
</tr>
	</table>
			</div>
	</div>
<!--card ends-->	
</div>
           <!-- container ends -->
</body>
</html>