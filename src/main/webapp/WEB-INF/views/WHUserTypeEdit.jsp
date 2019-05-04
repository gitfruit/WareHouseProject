<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2>Welcome to WHUserType Edit Page</h2>
			</div>

		

			<!-- Card body having form tag start to end -->
			<div class="card-body">


<form:form action="update" method="post" modelAttribute="whUserType">

<div class="row">
						<div class="col-3">
							<label for="userId" class="control-label"> User Id
								 </label>
						</div>
						<div class="col-5">

<form:input path="userId" readOnly="true"
				cssClass="readMore" />
				</div>
				</div>
				
				
<div class="row">
						<div class="col-3">
							<label for="userType" class="control-label">UserType
								 </label>
						</div>
						<div class="col-5">
				
          <form:radiobutton path="userType" value="vendor"/>VENDOR
                   <form:radiobutton path="userType" value="Customer"/>CUSTOMER
                   </div>
                   </div>
                   
                   <div class="row">
						<div class="col-3">
							<label for="userCode" class="control-label">UserCode
								 </label>
						</div>
						<div class="col-5">
                   
          <form:input path="userCode"/>
                      </div>
                      </div>

  
                   <div class="row">
						<div class="col-3">
							<label for="userFor" class="control-label">UserFor
								 </label>
						</div>
						<div class="col-5">

           <form:select path="userFor">
                   <form:option value="">-select-</form:option>
                   <form:option value="sale">SALE</form:option>
                   <form:option value="purchase">PURCHASE</form:option>
                   </form:select>
                   </div>
                   </div>
                
                 <div class="row">
						<div class="col-3">
							<label for="userEmail" class="control-label">UserEmail
								 </label>
						</div>
						<div class="col-5">
                
                  
         <form:input path="userEmail"/>
                      </div>
                      </div>

  
                 <div class="row">
						<div class="col-3">
							<label for="userContact" class="control-label">UserContact
								 </label>
						</div>
						<div class="col-5">

       <form:input path="userContact"/>
              </div>
              </div>
              
               <div class="row">
						<div class="col-3">
							<label for="userIDType" class="control-label">UserIDType
								 </label>
						</div>
						<div class="col-5">
              
              
        <form:select path="userIDType">
                   <form:option value="">-select-</form:option>
                   <form:option value="pancard">PANCARD</form:option>
                   <form:option value="aadhar">AADHAR</form:option>
                   <form:option value="voterid">VOTERID</form:option>
                   <form:option value="other">OTHER</form:option>
                   </form:select>  
                   </div>
                   </div>                
 
  
               <div class="row">
						<div class="col-3">
							<label for="idNumber" class="control-label">IDNUMBER
								 </label>
						</div>
						<div class="col-5">
              
 
          <form:input path="idNumber"/>
                    </div>
                    </div>

               <input type="submit" value="Update User"   class="btn btn-success" />         
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