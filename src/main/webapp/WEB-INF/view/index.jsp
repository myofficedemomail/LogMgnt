<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> -->
<style>
.swal2-popup {
	font-size: 1rem !important;
	/* font-family: Georgia,serif; */
}
.table td.fit, 
.table th.fit {
    white-space: nowrap;
    width: 1%;
}
</style>
<script>
	$(function() {
		/* $(".datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		}); */
		 $(".datepicker").datepicker({
			 changeMonth : true,
		     changeYear : true,
			 showButtonPanel: true,
		     closeText: 'Clear',
		     onClose: function (dateText, inst) {
		         if ($(window.event.srcElement).hasClass('ui-datepicker-close')) {
		             document.getElementById(this.id).value = '';
		         }
		     }
	    });
		$("#searchBtn").click(
				function() {
					if ($("#planName").val() == ""
							&& $("#planStatus").val() == ""
							&& $("#gender").val() == ""
							&& $("#startDate").val() == ""
							&& $("#endDate").val() == "") {
						//Swal.fire("Please Select Plan Name");
						alert("Please Select Any Of the Criteria");
						$("#planName").focus();
						return false;
					}
					document.searchform.action = "Reports";
					document.searchform.method = "POST";
					document.searchform.submit();
				});
		/*$("#planName").change(function() {
			if ($("#planName").val() == "") {
				alert("Please Select Plan Name");
				$("#planName").focus();
				return false;
			}else{
				document.searchform.action = "Reports";
				document.searchform.method = "POST";
				document.searchform.submit();
			}
		});
		$("#planStatus").change(function() {
			if ($("#planStatus").val() == "") {
				alert("Please Select Plan Status");
				$("#planStatus").focus();
				return false;
			}else{
				document.searchform.action = "Reports";
				document.searchform.method = "POST";
				document.searchform.submit();
			}
		});
		$("#gender").change(function() {
			if ($("#gender").val() == "") {
				alert("Please Select Plan Gender");
				$("#gender").focus();
				return false;
			}else{
				document.searchform.action = "Reports";
				document.searchform.method = "POST";
				document.searchform.submit();
			}
		});
		$("#startDate").change(function() {
			if ($("#startDate").val() == "") {
				alert("Please Select Start Date");
				$("#startDate").focus();
				return false;
			}else{
				document.searchform.action = "Reports";
				document.searchform.method = "POST";
				document.searchform.submit();
			}
		});
		$("#endDate").change(function() {
			if ($("#endDate").val() == "") {
				alert("Please Select End Date");
				$("#endDate").focus();
				return false;
			}else{
				document.searchform.action = "Reports";
				document.searchform.method = "POST";
				document.searchform.submit();
			}
		});*/
		$("#pdfBtn").click(function(){
			document.searchform.action = "Pdf";
			document.searchform.method = "POST";
			document.searchform.submit();
		});
		$("#excelBtn").click(function(){
			document.searchform.action = "Excel";
			document.searchform.method = "POST";
			document.searchform.submit();
		});
		$("#planName,#planStatus,#gender,#startDate,#endDate,.datepicker").change(function(){
			document.searchform.action = "Reports";
			document.searchform.method = "POST";
			document.searchform.submit();
		});
	});
</script>
</head>
<body>
	<form:form commandName="searchform" modelAttribute="searchform" name="searchform">
		<div class="container-fluid">
			<div class="p-2 mt-4"
				style="background-color: #e7e1f0; border: 2px solid #a277e6; border-radius: 8px;">
				<div class="row">
					<div class="col-4">
						<div class="">
							<div class="input-group">
								<label class="form-label">Plan Name</label>
							</div>
							<div class="input-group">
								<form:select path="planName" class="form-select" name="planName" id="planName">
									<option value="" selected>Select Plan Name</option>
									<form:option value="Cash">Cash</form:option>
									<form:option value="Food">Food</form:option>
									<form:option value="Medical">Medical</form:option>
									<form:option value="Employment">Employment</form:option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="">
							<div class="input-group">
								<label class="form-label">Plan Status</label>
							</div>
							<div class="input-group">
								<form:select path="planStatus" class="form-select" name="planStatus" id="planStatus">
									<option value="" selected>Select Plan Status</option>
									<form:option value="Approved">Approved</form:option>
									<form:option value="Denied">Denied</form:option>
									<form:option value="Terminated">Terminated</form:option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="">
							<div class="input-group">
								<label class="form-label">Gender</label>
							</div>
							<div class="input-group">
								<form:select path="gender" class="form-select" name="gender" id="gender">
									<option value="" selected>Select Gender</option>
									<form:option value="Male">Male</form:option>
									<form:option value="Female">Female</form:option>
								</form:select>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-4">
						<div class="">
							<div class="input-group">
								<label class="form-label">Start Date</label>
							</div>
							<div class="input-group">
								<form:input path="startDate" class="form-control datepicker" id="startDate"
									name="startDate" type="text" placeholder="Start Date" onkeydown="return false"
									readonly="readonly"/>
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="">
							<div class="input-group">
								<label class="form-label">End Date</label>
							</div>
							<div class="input-group">
								<form:input path="endDate" class="form-control datepicker" id="endDate"
									name="endDate" type="text" placeholder="End Date" onkeydown="return false"
									readonly="readonly"/>
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="">
							<div class="mt-4">
								<button type="button" id="searchBtn" class="btn btn-success">Search</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<c:if test="${not empty list}">
			<div class="p-2 mt-4"
				style="background-color: #e7e1f0; border: 2px solid #a277e6; border-radius: 8px;">
				<div class="row mb-2">
				<div class="col-10"></div>
				<div class="col-2">
				<button type="button" class="btn btn-danger" id="pdfBtn">PDF</button>
				<button type="button" class="btn btn-danger" id="excelBtn">Excel</button>
				</div>
				</div>
				<div class="row">
					<div class="col-12 table-responsive">
						<table class="table table-hover table-striped text-center">
							<tr>
								<th>Certizen Id</th>
								<th>Certizen Name</th>
								<th>Gender</th>
								<th>Benifit Amount</th>
								<th>Denial Reason</th>
								<th>Plan Name</th>
								<th>Plan Status</th>
								<th>Plan Start Dt.</th>
								<th>Plan End Dt.</th>
								<th>Terminated Dt.</th>
								<th>Termination Reason</th>
							</tr>
								<c:forEach items="${list}" var="dtls">
									<tr>
										<td>${dtls.citizen_id}</td>
										<td>${dtls.citizen_name}</td>
										<td>${dtls.gender}</td>
										<td>${dtls.benefit_amount}</td>
										<td>${dtls.denial_reason}</td>
										<td>${dtls.plan_name}</td>
										<td>${dtls.plan_status}</td>
										<td>${dtls.plan_start_date}</td>
										<td>${dtls.plan_end_date}</td>
										<td>${dtls.terminated_date}</td>
										<td>${dtls.termination_reason}</td>
									</tr>
								</c:forEach>
							</table>
					</div>
				</div>
			</div>
			</c:if>
			<c:if test="${empty list}">
					<div class="row mt-4">
					<div class="col-12 text-center text-danger"><img src="./resources/image/nodatafound.jpg"></div>
					</div>
			</c:if>
		</div>
	</form:form>
</body>
</html>