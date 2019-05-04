<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err {
	color: RED;
}
</style>
</head>
<body>


	<%@include file="Menu.jsp"%>
	<div class="container">


		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>Welcome to Item Edit Page</h2>
			</div>


			<!-- Card body having form tag start to end -->
			<div class="card-body">




				<form:form action="update" method="POST" modelAttribute="item">
					
					<div class="row">
					<div class="col-2">
												<label for="id" class="control-label">ItemId</label>
					</div>
					<div class="col-5">
               <form:input path="id" cssClass="err"/>					
					</div>
					</div>
							<div class="row">
						<div class="col-2">
							<label for="itemCode" class="control-label">Item Code
								 </label>
						</div>
						<div class="col-5">
        <form:input path="itemCode" />
        </div>
                 <div class="col-5">
               <form:errors path="itemCode" cssClass="text-danger" />
</div>  
</div>
       
       							<div class="row">
						<div class="col-2">
							<label for="Dimensions" class="control-label">Dimensions
								 </label>
						</div>
						<div class="col-7">
        W: <form:input path="Dimensions" /> L:<form:input path="Dimensions"/> H:<form:input path="Dimensions"/>
        </div>
                 <div class="col-3">
               <form:errors path="Dimensions" cssClass="text-danger" />  
              
</div>  
</div>

     
       							<div class="row">
						<div class="col-2">
							<label for="baseCost" class="control-label">Base Cost 
								 </label>
						</div>
						<div class="col-5">
        <form:input path="baseCost" /> 
        </div>
                 <div class="col-5">
               <form:errors path="baseCost" cssClass="text-danger" />  
</div>  
</div>

   							<div class="row">
						<div class="col-2">
							<label for="baseCurrency" class="control-label">Base Currency 
								 </label>
						</div>
						<div class="col-5">
        <form:select path="baseCurrency" > 
        <form:option  value=" ">-select-</form:option>
        <form:option value="INR">INR</form:option>
        <form:option value="USD">USD</form:option>
        <form:option value="AUS">AUS</form:option>
        <form:option value="ERU">ERU</form:option>
        </form:select>
        </div>
                 <div class="col-5">
               <form:errors path="baseCurrency" cssClass="text-danger" />  
</div>  
</div>


     
       							<div class="row">
						<div class="col-2">
							<label for="inote" class="control-label">Description
								 </label>
						</div>
						<div class="col-5">
        <form:input path="inote" /> 
        </div>
                 <div class="col-5">
               <form:errors path="inote" cssClass="text-danger" />  
</div>  
</div>
       
             <div class="row">
             <div class="col-4">
             </div>
             <div class="col-4">
                 <input type="submit" value="update" class="btn btn-success"/>
             </div>
             </div>
				</form:form>
			</div>
			  <!--  card-body ends -->
			
			<c:if test="${message ne null }">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>
			
			<!-- card end -->
		</div>
		
		</div>
		    <!-- container end -->
</body>
</html>