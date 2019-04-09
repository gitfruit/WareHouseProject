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
	<h2>Welcome to OrderMethod Data Page</h2>
    <a href="excel">EXCEL</a> <br>
    <a href="pdf">PDF</a>
	<c:if test="${empty list}">              
		<h3>NO Data found</h3>
	</c:if>
	
	<c:if test="${!empty list}">
		<table border=1>
			<tr>
				<th>Id</th>
				<th>Mode</th>
				<th>Code</th>
				<th>ExeType</th>
				<th>Note</th>
				<th >OrderAccepts</th>
				<th colspan="4">Operations</th>
				<th>
			</tr>
			<c:forEach items="${list}" var="ob">
				<tr>
					<td><c:out value="${ob.orderId}" /></td>
					<td><c:out value="${ob.orderMode}" /></td>
					<td><c:out value="${ob.orderCode}" /></td>
					<td><c:out value="${ob.exeType}" /></td>
					<td><c:out value="${ob.note}" /></td>
					<td><c:out value="${ob.orderAccepts}" /></td>
					<td><a href="delete?id=${ob.orderId}">DELETE</a></td>
					<td><a href="edit?id=${ob.orderId}">EDIT</a></td>
					<td><a href="pdf?id=${ob.orderId}">PDF</a></td>
					<td><a href="excel?id=${ob.orderId}">EXCEL</a></td>
					<td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	${message}
</body>
</html>