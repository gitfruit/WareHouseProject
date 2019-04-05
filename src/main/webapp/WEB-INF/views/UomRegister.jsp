<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Uom Register</h2>
	<form:form action="save" method="post" modelAttribute="uom">
		<pre>

UomType      :<form:select path="uomType">
              <form:option value="">-select-</form:option>
              <form:option value="Pack">Pack</form:option>
              <form:option value="NoPack">NOPack</form:option>
              <form:option value="NA">NA</form:option>
              </form:select>
   
UOM CODE     :<form:input path="uomCode" />

ENABELD      :<form:radiobutton path="enableUom" value="Yes" />YES
              <form:radiobutton path="enableUom" value="No" />NO

METACODE      :<form:input path="metaCode" />

ADJUST SIZE   :<form:radiobutton path="adjSize" value="L" />L
               <form:radiobutton path="adjSize" value="M" />M
               <form:radiobutton path="adjSize" value="R" />R
               
                
NOTE          :<form:textarea path="note" />


                  <input type="submit" value="Register" />
                
</pre>
	</form:form>
	${read}
	<a href="showall">VIEW ALL</a>
</body>
</html>