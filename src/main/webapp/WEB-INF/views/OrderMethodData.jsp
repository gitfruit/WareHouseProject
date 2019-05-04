<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="Menu.jsp" %>
	<div class="container">

		<div class="card">
			
			<div class="card-header bg-primary text-white">
	<h2>Welcome to OrderMethod Data Page</h2>
			</div>


			<div class="card-body">


	<c:if test="${empty list}">              
		<h3>NO Data found</h3>
	</c:if>
	
	<c:if test="${!empty list}">
<table class="table table-bordered table-hover">
						<tr class="table-info text-success">			
				<th>Id</th>
				<th>MODE</th>
				<th colspan="5">Operations</th>
				<th>
			</tr>
			<c:forEach items="${list}" var="ob">
				<tr>
					<td><c:out value="${ob.orderId}" /></td>
					<td><c:out value="${ob.orderMode}" /></td>
					<td><a href="delete?id=${ob.orderId}" data-toggle="tooltip" data-placement="top" title="delete" ><img src="../resources/images/delete.png" width="40" height="40" /></a></td>
					<td><a href="edit?id=${ob.orderId}" data-toggle="tooltip" data-placement="top" title="edit" ><img src="../resources/images/edit2.png" width="40" height="40" /></a></td>
					<td><a href="pdf?id=${ob.orderId}" data-toggle="tooltip" data-placement="top" title="pdf" ><img src="../resources/images/pdf2.png" width="40" height="40" /></a></td>
					<td><a href="excel?id=${ob.orderId}" data-toggle="tooltip" data-placement="top" title="excel"  ><img src="../resources/images/excel.png" width="40" height="40" /></a></td>
					<td><a href="viewone?id=${ob.orderId}" data-toggle="tooltip" data-placement="top" title="viewone"  ><img src="../resources/images/view.png" width="40" height="40" /></a>
					<td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${message ne null}">
			<b class=" bg-warning text-danger">${message}</b>
			</c:if>
	
	</div>
	<!-- card body ends -->
	
	<div class="card-footer">
			<a href="excel"  data-toggle="tooltip" data-placement="top" title="excel" ><img src="../resources/images/BulkExcel.png" width="150" height="100"  /></a>
	<a href="pdf" data-toggle="tooltip" data-placement="top" title="pdf" ><img src="../resources/images/BulkPdf.png" width="150" height="100" /></a>
	<a href="charts" data-toggle="tooltip" data-placement="top" title="charts" > <img src="../resources/images/charts.png"
					width="150" height="100" /> </a>
	</div>

	</div>
	<!-- card close -->
	</div>
	<!-- Container end -->
	
</body>
</html>