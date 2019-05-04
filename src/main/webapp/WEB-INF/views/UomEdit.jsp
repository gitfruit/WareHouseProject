<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.readMore {
	background-color: #D3D3D3;
}
</style>
</head>
<body>

<%@include file="Menu.jsp"%>
	<div class="container">


		<div class="card">
			<div class="card-header bg-primary text-white">
	<h2>Welcome to Uom Register</h2>
			</div>

<!-- Card body having form tag start to end -->
			<div class="card-body">

	<form:form action="update" method="post" modelAttribute="uom">
		
		<div class="row">
						<div class="col-3">
							<label for="uomId" class="control-label">UomId</label>
						</div>
						<div class="col-5">

<form:input path="uomId" readOnly="true"
				cssClass="readMore" />
				</div>
				</div>
                 
                 <div class="row">
						<div class="col-3">
							<label for="uomType" class="control-label">UomType</label>
						</div>
						<div class="col-5">
<form:select path="uomType">
              <form:option value="">-select-</form:option>
              <form:option value="Pack">Pack</form:option>
              <form:option value="NoPack">NOPack</form:option>
              <form:option value="NA">NA</form:option>
              </form:select>
   </div>
   </div>

  <div class="row">
						<div class="col-3">
							<label for="uomCode" class="control-label">UomCode</label>
						</div>
						<div class="col-5">

<form:input path="uomCode" />
</div>
</div>

<div class="row">
						<div class="col-3">
							<label for="enableUom" class="control-label">EnableUom</label>
						</div>
						<div class="col-5">
<form:radiobutton path="enableUom" value="Yes" />YES
              <form:radiobutton path="enableUom" value="No" />NO
              </div>
              </div>

<div class="row">
						<div class="col-3">
							<label for="metaCode" class="control-label">MetaCode</label>
						</div>
						<div class="col-5">

<form:input path="metaCode" />
</div>
</div>


<div class="row">
						<div class="col-3">
							<label for="adjSize" class="control-label">AdjustSize</label>
						</div>
						<div class="col-5">
<form:radiobutton path="adjSize" value="L" />L
               <form:radiobutton path="adjSize" value="M" />M
               <form:radiobutton path="adjSize" value="R" />R
               </div>
               </div>
               
               <div class="row">
						<div class="col-3">
							<label for="note" class="control-label">Description</label>
						</div>
						<div class="col-5">
                
<form:textarea path="note" />

</div>
</div>
                  <input type="submit" value="Update" class="btn btn-success" />
                

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