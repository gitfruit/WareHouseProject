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
	<a href="excel">EXCEL EXPORT</a>
	<a href="pdf">PDF EXPORT</a>
	<c:if test="${empty list}">
		<h3>NO Data Found</h3>
	</c:if>

	<c:if test="${!empty list}">

		<table border="1">
			<tr>
				<td>UomType</td>
				<td>UomCode</td>
				<td>Enabled</td>
				<td>MetaCode</td>
				<td>AdjustSize</td>
				<td>Note</td>
				<td colspan="4">OPERATIONS</td>
			</tr>

			<c:forEach items="${list}" var="ob">
				<tr>
					<td><c:out value="${ob.uomId}" /></td>
					<td><c:out value="${ob.uomType}" /></td>
					<td><c:out value="${ob.uomCode}" /></td>
					<td><c:out value="${ob.enableUom}" /></td>
					<td><c:out value="${ob.metaCode}" /></td>
					<td><c:out value="${ob.note}" /></td>
					<td><a href="delete?id=${ob.uomId}">DELETE</a></td>
					<td><a href="edit?id=${ob.uomId}">EDIT</a></td>
					<td><a href="excel?id=${ob.uomId}">EXCEL</a></td>
					<td><a href="pdf?id=${ob.uomId}">PDF</a>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	${message}
</body>
</html>