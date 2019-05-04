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
<h2>Welcome to OrderMethod View Page</h2>
			</div>

			<div class="card-body">
				<table class="table table-striped table-bordered">
<tr>
<th>Id</th>
<td>${orm.orderId}</td>
</tr>
<tr>
<th>Mode</th>
<td>${orm.orderMode}</td>
</tr>
<tr>
<th>Code</th>
<td>${orm.orderCode}</td>
</tr>
<tr>
<th>ExeType</th>
<td>${orm.exeType}</td>
</tr>
<tr>
<th>Note</th>
<td>${orm.note}</td>
</tr>
			</table>
			</div>
	</div>
<!--card ends-->	
</div>
           <!-- container ends -->
</body>
</html>