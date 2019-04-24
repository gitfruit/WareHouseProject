<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Uom View Page</h2>
<table border="1" >
<tr>
<th>Id</th>
<td>${uom.uomId}</td>
</tr>
<tr>
<th>Type</th>
<td>${uom.uomType}</td>
</tr>
<tr>
<th>Code</th>
<td>${uom.uomCode}</td>
</tr>
<tr>
<th>Enable</th>
<td>${uom.enableUom}</td>
</tr>
<tr>
<th>MetaCode</th>
<td>${uom.metaCode}</td>
</tr>
<tr>
<th>AdjSize</th>
<td>${uom.adjSize}</td>
</tr>
<tr>
<th>Note</th>
<td>${note}</td>
</tr>
</table>
</body>
</html>