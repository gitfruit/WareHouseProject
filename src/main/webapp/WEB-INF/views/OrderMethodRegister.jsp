<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
<h2> Welcome to OrderMethod Register Page</h2>
<form:form action="save" method="POST" modelAttribute="orderMethod">
<pre>

OrderMode       :  <form:radiobutton path="orderMode" value="SALE"/>SALE
                   <form:radiobutton path="orderMode" value="PURCHASE"/>PURCHASE
                   
OrderCode       :  <form:input path="orderCode"/>

Execute Type    :  <form:select path="exeType">
                   <form:option value="	">-select-</form:option>
                   <form:option value="FIFO">FIFO</form:option>
                   <form:option value="LIFO">FIFO</form:option>
                   <form:option value="FCDO">FCFO</form:option>
                   <form:option value="FEFO">FEFO</form:option>
                   </form:select>
                   
OrderAccept     :  <form:checkbox  path="orderAccepts" value="Multi-Model"/>Multi-Model
                   <form:checkbox path="orderAccepts" value="Accept Return"/>Accept Return
                   <form:checkbox path="orderAccepts" value="Service Extend"/>Service Extend
                   
Description     :  <form:textarea path="note"/>

        <input type="submit" value="Create Order Method">
                   
</pre>
</form:form>
${message} <br>
<a href="charts">VIEW CHARTS</a> <br>
<a href="all">View All</a>
</body>
</html>