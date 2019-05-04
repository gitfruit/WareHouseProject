<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<h2>Welcome to Uom Data Type Page</h2>
			</div>


			<div class="card-body">


	
	
	<c:if test="${empty list}">
		<h3>NO Data Found</h3>
	</c:if>

	<c:if test="${!empty list}">

		<table class="table table-bordered table-hover">
						<tr class="table-info text-success">
				<td>UomType</td>
				<td>UomCode</td>
				<td colspan="5">OPERATIONS</td>
			</tr>

			<c:forEach items="${list}" var="ob">
				<tr>
					<td><c:out value="${ob.uomId}" /></td>
					<td><c:out value="${ob.uomType}" /></td>
					<td><a href="delete?id=${ob.uomId}"><img src="../resources/images/delete.png" width="40" height="40"  data-toggle="tooltip" data-placement="top" title="delete"  /></a></td>
					<td><a href="edit?id=${ob.uomId}"><img src="../resources/images/edit2.png" width="40" height="40"  data-toggle="tooltip" data-placement="top" title="edit"  /></a></td>
					<td><a href="excel?id=${ob.uomId}"><img src="../resources/images/excel.png" width="40" height="40"  data-toggle="tooltip" data-placement="top" title="excel"  /></a></td>
					<td><a href="pdf?id=${ob.uomId}"><img src="../resources/images/pdf2.png" width="40" height="40"  data-toggle="tooltip" data-placement="top" title="pdf"  /></a></td>
					<td><a href="viewone?id=${ob.uomId}"><img src="../resources/images/view.png" width="40" height="40"  data-toggle="tooltip" data-placement="top" title="viewone" /></a></td> 
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
		<a href="excel"><img src="../resources/images/BulkExcel.png" width="150" height="100"   data-toggle="tooltip" data-placement="top" title="excel" /></a>
	<a href="pdf"><img src="../resources/images/BulkPdf.png" width="150" height="100"  data-toggle="tooltip" data-placement="top" title="pdf"  /></a>
	<a href="charts"> <img src="../resources/images/charts.png"
					width="150" height="100"  data-toggle="tooltip" data-placement="top" title="charts"  />
	</div>

	</div>
	<!-- card close -->
	</div>
	<!-- Container end -->
</body>
</html>