<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<%@include file="Menu.jsp" %>
	<div class="container">

		<div class="card">
			
			<div class="card-header bg-primary text-white">
				<h3>Welcome to Shipment Data Page</h3>
			</div>


			<div class="card-body">
				
				<c:if test="${empty list}">
					<h4>No Data Found</h4>
				</c:if>
				
				<c:if test="${!empty list}">
					<table class="table table-bordered table-hover">
						<tr class="table-info text-success">
							<th>ID</th>
							<th>MODE</th>
							<th>CODE</th>
							
							<th colspan="5">OPERATIONS</th>
						</tr>
						<c:forEach items="${list}" var="ob">
							<tr>
								<td> <b><c:out value="${ob.shipmentId }" /></b> </td>
								<td><c:out value="${ob.shipmentMode }" /></td>
								<td><c:out value="${ob.shipmentCode }" /></td>
								
								<td><a href="delete?id=${ob.shipmentId}"> <img
										src="../resources/images/delete.png" width="40" height="40"  data-toggle="tooltip" data-placement="top" title="delete" />
								</a></td>
								<td><a href="edit?id=${ob.shipmentId}"> <img
										src="../resources/images/edit.png" width="40" height="40"  data-toggle="tooltip" data-placement="top" title="edit"  />
								</a></td>
								<td><a href="viewOne?id=${ob.shipmentId}"> <img
										src="../resources/images/view.png" width="40" height="40"   data-toggle="tooltip" data-placement="top" title="viewone" />
								</a></td>

								<td><a href="excel?id=${ob.shipmentId}"> <img
										src="../resources/images/excel.png" width="40" height="40"  data-toggle="tooltip" data-placement="top" title="excel"  />
								</a></td>

								<td><a href="pdf?id=${ob.shipmentId}"> <img
										src="../resources/images/pdf.png" width="40" height="40"  data-toggle="tooltip" data-placement="top" title="pdf" />
								</a></td>

							</tr>
						</c:forEach>

					</table>
				</c:if>
					<c:if test="${message ne null}">
			<b class=" bg-warning text-danger">${message}</b>
			</c:if>
				
			</div>
			<!-- card Body end -->

<div class="card-footer">
		<a href="excel"> <img src="../resources/images/BulkExcel.png"
					width="150" height="100"   data-toggle="tooltip" data-placement="top" title="excel" />
				</a> 
				
				<a href="pdf"> <img src="../resources/images/BulkPdf.png"
					width="150" height="100"  data-toggle="tooltip" data-placement="top" title="pdf"  />
				</a>
				
				<a href="charts"> <img src="../resources/images/charts.png"
					width="150" height="100"  data-toggle="tooltip" data-placement="top" title="charts"  />
				</a>
			</div>
			


		</div>
		<!-- card close -->

	</div>
	<!--  Container end -->
</body>
</html>