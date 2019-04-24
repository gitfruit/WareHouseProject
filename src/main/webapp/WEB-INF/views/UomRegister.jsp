<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.err{color:red;}
</style>
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
              <form:errors  path="uomType" cssClass="err"/>
   
UOM CODE     :<form:input path="uomCode" />
              <form:errors  path="uomCode" cssClass="err"/>

ENABELD      :<form:radiobutton path="enableUom" value="Yes" />YES
              <form:radiobutton path="enableUom" value="No" />NO
              <form:errors  path="enableUom" cssClass="err"/>

METACODE      :<form:input path="metaCode" />
              <form:errors  path="metaCode" cssClass="err"/>

ADJUST SIZE   :<form:radiobutton path="adjSize" value="L" />L
               <form:radiobutton path="adjSize" value="M" />M
               <form:radiobutton path="adjSize" value="R" />R
              <form:errors  path="adjSize" cssClass="err"/>
               
                
NOTE          :<form:textarea path="note" />
              <form:errors  path="note" cssClass="err"/>

      <input type="submit" value="Register" />
    </pre>
	</form:form>
	${read} <br>
	<a href="charts">VIEWCHARTS</a> <br> 
	<a href="showall">VIEW ALL</a>
</body>
</html>