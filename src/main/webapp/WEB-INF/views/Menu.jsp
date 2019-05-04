<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"
	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />


<!-- code starts from here -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

  
   <nav class="navbar navbar-expand-sm navbar-dark" style="background:hotpink;">

  <!-- Brand -->
  <a class="navbar-brand background-color: #F8F8F8" href="#"    >
  WAREHOUSE
  	<img  src="../resources/images/logo.png" width="50" height="50">
  </a>

  <!-- Links -->
  <ul class="navbar-nav ">
   
   
    <li class="nav-item">
      <a class="nav-link" href="#">Home</a>
    </li>
    
		
	<!-- Copy below code for another menu option -->
		
    <!-- Shipment Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown"  
   >
        <b>SHIPMENT-TYPE</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/shipment/register">Register</a>
        <a class="dropdown-item" href="${url}/shipment/all">View All</a>
        <a class="dropdown-item" href="${url}/shipment/charts">Reports</a>
      </div>
    </li>
    <!-- Shipment Type end -->
    
    <!-- copy upto this -->
    
    
    
    <!-- Uom Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>Uom</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/uom/register">Register</a>
        <a class="dropdown-item" href="${url}/uom/all">View All</a>
        <a class="dropdown-item" href="${url}/uom/charts">Reports</a>
      </div>
    </li>
    <!-- Uom Type end -->
    
    <!-- OrderMethod Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>OrderMethod</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/ordermethod/register">Register</a>
        <a class="dropdown-item" href="${url}/ordermethod/all">View All</a>
        <a class="dropdown-item" href="${url}/ordermethod/charts">Reports</a>
      </div>
    </li>
    <!-- OrderMethod Type end -->
    <!-- copy upto this -->
    
    <!-- WhUserType Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>WhUserType</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/whusertype/register">Register</a>
        <a class="dropdown-item" href="${url}/whusertype/all">View All</a>
        <a class="dropdown-item" href="${url}/whusertype/charts">Reports</a>
      </div>
    </li>
    <!-- WhUserType Type end -->
    
    <!-- copy upto this -->
    
    <!-- Item Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>Item</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/item/register">Register</a>
        <a class="dropdown-item" href="${url}/item/all">View All</a>
        <a class="dropdown-item" href="${url}/item/charts">Reports</a>
      </div>
    </li>
    <!-- Item Type end -->
    <!-- copy upto this -->
    
    <!-- PurchaseOrder Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>PurchaseOrder</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/PurchaseOrder/register">Register</a>
        <a class="dropdown-item" href="${url}/PurchaseOrder/all">View All</a>
        <a class="dropdown-item" href="${url}/PurchaseOrder/charts">Reports</a>
      </div>
    </li>
    <!-- PurchaseOrder Type end -->
    <!-- copy upto this -->
    
    <!-- SaleOrder Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>SaleOrder</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/saleorder/register">Register</a>
        <a class="dropdown-item" href="${url}/saleorder/all">View All</a>
        <a class="dropdown-item" href="${url}/saleorder/charts">Reports</a>
      </div>
    </li>
    <!-- SaleOrder Type end -->
    <!-- copy upto this -->
    
    <!-- User Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>User</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/user/register">Register</a>
        <a class="dropdown-item" href="${url}/user/all">View All</a>
        <a class="dropdown-item" href="${url}/user/charts">Reports</a>
      </div>
    </li>
    <!-- User Type end -->
    <!-- copy upto this -->
    
    
    
    
    
    <li class="nav-item">
      <a class="nav-link" href="#">Logout</a>
    </li>
  </ul>
</nav>
