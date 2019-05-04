<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
</head>
<body>


	<%@include file="Menu.jsp"%>
	<div class="container">


		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>Welcome to Shipment Type Register Page</h2>
			</div>


			<!-- Card body having form tag start to end -->
			<div class="card-body">




				<form:form action="save" method="POST" modelAttribute="shipmentType">
					
		
		<div class="row">
						<div class="col-3">
							<label for="shipmentMode" class="control-label">Shipment
								Mode</label>
						</div>
						<div class="col-5">
<form:select path="shipmentMode">
               <form:option value="">-Select-</form:option>
               <form:option value="AIR">Air</form:option>
               <form:option value="TRAIN">Train</form:option>
               <form:option value="TRUCK">Truck</form:option>
               <form:option value="SHIP">Ship</form:option>
               </form:select>
             </div>
						<div class="col-4">
							<form:errors path="shipmentMode" cssClass="text-danger" />
						</div>
					</div>
					
					<div class="row">
						<div class="col-3">
							<label for="shipmentCode" class="control-label"> Shipment
								Code </label>
						</div>
						<div class="col-5">
        <form:input path="shipmentCode" />
        </div>
                 <div class="col-4">
               <form:errors path="shipmentCode" cssClass="text-danger" />
</div>  
</div>
       
       <div class="row">
           <div class="col-3">
           <label for="shipmentEnable" class="control-label">Shipment Enable</label>
           </div>
           <div class="col-5">
<form:select path="shipmentEnable">
 <form:option value="">-Select-</form:option>
                 <form:option value="YES">YES</form:option>
                 <form:option value="NO">NO</form:option>
                 </form:select>
                  </div>
                  <div class="col-3">
                 <form:errors path="shipmentEnable" cssClass="text-danger"  />
              </div>
                </div> 
                
                <div class="row">
                <div class="col-3">
                <label class="shipmentGrade">ShipmentGrade</label>
                </div>
                <div class="col-5">
           <form:radiobutton path="shipmentGrade" value="A" />A
                 <form:radiobutton path="shipmentGrade" value="B" />B
                 <form:radiobutton path="shipmentGrade" value="C" />C
                 </div>
                 
                 <div class="col-4">
                 <form:errors path="shipmentGrade" cssClass="text-danger"  />  
                 </div>
                 </div>  
                 
                 <div class="row">   
                 <div class="col-3">
                 <label for="snote" class="control-label">Description</label>
                 </div>   
                       
                       <div class="col-5">
     <form:textarea path="snote" />
     </div>
                <div class="col-4">
                 <form:errors path="snote" cssClass="text-danger"  />
                 </div>
                 </div>
                 
                 <div class="row">
                 <div class="col-4"></div>
                 </div>
                 <div class="row">
                 <div class="col-4"></div>
                 </div>
                 <div class="row">
						<div class="col-3"></div>
						<div class="col-5">
                 <input type="submit" value="register" class="btn btn-success"/>
                 </div>  
                 </div>
	
				</form:form>
			</div>
			  <!--  card-body ends -->
			
			<c:if test="${msg ne null }">
				<div class="card-footer bg-info text-white">${msg}</div>
			</c:if>
			
			<!-- card end -->
		</div>
		
		</div>
		    <!-- container end -->
</body>
</html>