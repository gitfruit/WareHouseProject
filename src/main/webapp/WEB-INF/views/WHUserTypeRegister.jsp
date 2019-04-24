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
<h2>Welcome to WHUserType Register Page</h2>

<form:form action="save" method="post" modelAttribute="wHUserType">
 <pre>
 UserType         :<form:radiobutton path="userType" value="vendor"/>VENDOR
                   <form:radiobutton path="userType" value="Customer"/>CUSTOMER
                   
UserCode          :<form:input path="userCode"/>

UserFor           :<form:select path="userFor">
                   <form:option value="">-select-</form:option>
                   <form:option value="sale">SALE</form:option>
                   <form:option value="purchase">PURCHASE</form:option>
                   </form:select>
                  
UserEmail         :<form:input path="userEmail"/>

UserContact       :<form:input path="userContact"/>

UserIDType        :<form:select path="userIDType">
                   <form:option value="">-select-</form:option>
                   <form:option value="pancard">PANCARD</form:option>
                   <form:option value="aadhar">AADHAR</form:option>
                   <form:option value="voterid">VOTERID</form:option>
                   <form:option value="other">OTHER</form:option>
                   </form:select>                  
 
IDNUMBER          :<form:input path="idNumber"/>

               <input type="submit" value="Create User"/>         
                     
 </pre>
</form:form>
${message} <br>
<a href="all">VIEWALL</a> <br>
<a href="charts">VIEWCHARTS</a>
</body>
</html>