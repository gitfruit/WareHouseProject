<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
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
			
	<form:form action="save" method="post" modelAttribute="uom">
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
              <div class="col-4">
              <form:errors  path="uomType" cssClass="text-danger"/>
              </div>
              </div>
   
   <div class="row">
						<div class="col-3">
							<label for="uomCode" class="control-label">UomCode</label>
						</div>
						<div class="col-5">
             <form:input path="uomCode" />
             </div>
             <div class="col-4">
              <form:errors  path="uomCode" cssClass="text-danger"/>
</div>
</div>

 
                         <div class="row">
						<div class="col-3">
							<label for="uomCode" class="control-label">UomCode</label>
						</div>
						<div class="col-5">

<form:radiobutton path="enableUom" value="Yes" />YES
              <form:radiobutton path="enableUom" value="No" />NO
              </div>
              <div class="col-4">
             <form:errors  path="enableUom" cssClass="text-danger"/>
                  </div>
                  </div>
                  
                  <div class="row">
						<div class="col-3">
							<label for="metaCode" class="control-label">MetaCode</label>
						</div>
						<div class="col-5">
                  <form:input path="metaCode" />
                  </div>
                  <div class="col-4">
              <form:errors  path="metaCode" cssClass="text-danger"/>
</div>
</div>

<div class="row">
						<div class="col-3">
							<label for="adjSize" class="control-label">Adjust Size</label>
						</div>
                       <div class="col-5">
<form:radiobutton path="adjSize" value="L" />L
               <form:radiobutton path="adjSize" value="M" />M
               <form:radiobutton path="adjSize" value="R" />R
               </div>
               <div class="col-4">
              <form:errors  path="adjSize" cssClass="text-danger"/>
               </div>
               </div>
                <div class="row">
						<div class="col-3">
							<label for="note" class="control-label">Description</label>
						</div>
                       <div class="col-5">
<form:textarea path="note" />
</div>   
          <div class="col-4">
              <form:errors  path="note" cssClass="text-danger"/>
</div>
</div>
<div class="row">
						<div class="col-3"></div>
						<div class="col-5">
      <input type="submit" value="Register" class="btn btn-success"/>
    </div>
    </div>
	</form:form>
		</div>
			  <!--  card-body ends -->
			
			<c:if test="${read ne null }">
			<div class="card-footer bg-info text-white">${read}</div>
			</c:if>
	
	</div>
	</div>
</body>
</html>