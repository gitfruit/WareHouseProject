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

	<h2>Welcome to Shipment Type Data Page</h2>
	<a href="excel">Excel Export</a>
	<a href="pdf">Pdf Export</a>

	<c:if test="${empty list}">
		<h3>No Data Found</h3>
	</c:if>

	<c:if test="${!empty list}">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>MODE</th>
				<th>CODE</th>
				<th>ENABLE</th>
				<th>GRADE</th>
				<th>NOTE</th>
				<th colspan="4">OPERATIONS</th>
			</tr>

			<c:forEach items="${list}" var="ob">
				<tr>
					<td><c:out value="${ob.shipmentId}" /></td>
					<td><c:out value="${ob.shipmentMode}" /></td>
					<td><c:out value="${ob.shipmentCode}" /></td>
					<td><c:out value="${ob.shipmentEnable}" /></td>
					<td><c:out value="${ob.shipmentGrade}" /></td>
					<td><c:out value="${ob.snote}" /></td>
					<td><a href="delete?id=${ob.shipmentId}">DELETE</a></td>
					<td><a href="edit?id=${ob.shipmentId}">EDIT</a></td>
					<td><a href="excel?id=${ob.shipmentId}">EXCEL</a>
					<td><a href="pdf?id=${ob.shipmentId}">PDF</a>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	${message}
</body>
</html>