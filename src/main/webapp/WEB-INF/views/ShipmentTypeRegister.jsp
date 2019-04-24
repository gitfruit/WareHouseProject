<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err{color:red;}
</style>
</head>
<body>
	<h2>Welcome to ShipmentType Register Page</h2>

	<form:form action="save" method="POST" modelAttribute="shipmentType">
		<pre>
ShipmentMode :<form:select path="shipmentMode">
               <form:option value="">-Select-</form:option>
               <form:option value="AIR">Air</form:option>
               <form:option value="TRAIN">Train</form:option>
               <form:option value="TRUCK">Truck</form:option>
               <form:option value="SHIP">Ship</form:option>
               </form:select>
               <form:errors path="shipmentMode" cssClass="err"/>
               
ShipmentCode :<form:input path="shipmentCode" />
               <form:errors path="shipmentCode" cssClass="err"/>

EnableShipment  :<form:select path="shipmentEnable">
                 <form:option value="">-Select-</form:option>
                 <form:option value="YES">YES</form:option>
                 <form:option value="NO">NO</form:option>
                 </form:select>
                 <form:errors path="shipmentEnable"	cssClass="err"/>
                 
ShipmentGrade   :<form:radiobutton path="shipmentGrade" value="A" />A
                 <form:radiobutton path="shipmentGrade" value="B" />B
                 <form:radiobutton path="shipmentGrade" value="C" />C
                 <form:errors path="shipmentGrade" cssClass="err"/>                 
Description     :<form:textarea path="snote" />
                 <form:errors path="snote" cssClass="err" />
                 
                 <input type="submit" value="register" />
</pre>
	</form:form>

	${msg}<br>
	<a href="all">VIEW ALL</a> <br>
	<a href="charts">VIEWCHARTS</a>
</body>
</html>