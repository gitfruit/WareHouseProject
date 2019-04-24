<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Welcome to ShipmentType View Page</h2>
<table border="1">
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
</body>
</html>