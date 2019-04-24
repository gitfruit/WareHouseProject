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

	<h2>Welcome to Uom Data Type Page</h2>
	<a href="excel"><img src="../resources/images/BulkExcel.png" width="80" height="80" /></a>
	<a href="pdf"><img src="../resources/images/BulkPdf.png" width="80" height="80" /></a>
	<c:if test="${empty list}">
		<h3>NO Data Found</h3>
	</c:if>

	<c:if test="${!empty list}">

		<table border="1">
			<tr>
				<td>UomType</td>
				<td>UomCode</td>
				<td colspan="5">OPERATIONS</td>
			</tr>

			<c:forEach items="${list}" var="ob">
				<tr>
					<td><c:out value="${ob.uomId}" /></td>
					<td><c:out value="${ob.uomType}" /></td>
					<td><a href="delete?id=${ob.uomId}"><img src="../resources/images/delete.png" width="40" height="40" /></a></td>
					<td><a href="edit?id=${ob.uomId}"><img src="../resources/images/edit2.png" width="40" height="40" /></a></td>
					<td><a href="excel?id=${ob.uomId}"><img src="../resources/images/excel.png" width="40" height="40" /></a></td>
					<td><a href="pdf?id=${ob.uomId}"><img src="../resources/images/pdf2.png" width="40" height="40" /></a></td>
					<td><a href="viewone?id=${ob.uomId}"><img src="../resources/images/view.png" width="40" height="40"/></a></td> 
				</tr>
			</c:forEach>
		</table>
	</c:if>
	${message}
</body>
</html>