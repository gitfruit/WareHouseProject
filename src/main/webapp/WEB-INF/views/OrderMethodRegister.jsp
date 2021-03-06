<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="Menu.jsp"%>
	<div class="container">


		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>Welcome to OrderMethod Register Page</h2>
			</div>

			<!-- Card body having form tag start to end -->
			<div class="card-body">

				<form:form action="save" method="POST" modelAttribute="orderMethod">

					<div class="row">
						<div class="col-3">
							<label for="orderMode" class="control-label">OrderMode</label>
						</div>

						<div class="col-5">
							<form:radiobutton path="orderMode" value="SALE" />
							SALE
							<form:radiobutton path="orderMode" value="PURCHASE" />
							PURCHASE
						</div>

						<div class="col-4">
							<form:errors path="orderMode" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="orderCode" class="control-label">OrderCode</label>
						</div>

						<div class="col-5">

							<form:input path="orderCode" />
						</div>
						<div class="col-4">
							<form:errors path="orderCode" cssClass="text-danger" />
						</div>
					</div>


					<div class="row">
						<div class="col-3">
							<label for="exeType" class="control-label">Execute Type </label>
						</div>

						<div class="col-5">
							<form:select path="exeType">
								<form:option value="	">-select-</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">FIFO</form:option>
								<form:option value="FCDO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<form:errors path="exeType" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="orderAccepts" class="control-label">OrderAccept
							</label>
						</div>

						<div class="col-5">

							
							<form:checkbox path="orderAccepts" value="Multi-Model" />
							Multi-Model
							<form:checkbox path="orderAccepts" value="Accept Return" />
							Accept Return
							<form:checkbox path="orderAccepts" value="Service Extend" />
							Service Extend
						</div>
						<div class="col-4">
							<form:errors path="orderAccepts" cssClass="text-danger" />
						</div>
                          </div>
						<div class="row">
							<div class="col-3">
								<label for="note" class="control-label">Description </label>
							</div>

							<div class="col-5">

								<form:textarea path="note" />
							</div>
							<div class="col-4">
								<form:errors path="note" cssClass="text-danger" />
							</div>
							</div>

<div class="row">
						<div class="col-3"></div>
						<div class="col-5">
							<input type="submit" value="Create Order Method"
								class="btn btn-success">
								</div>
								</div>
				</form:form>
			</div>
			<!--  card-body ends -->

			<c:if test="${message ne null }">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>

		</div>
	</div>
</body>
</html>