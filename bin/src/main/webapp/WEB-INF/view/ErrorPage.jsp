<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript">
	$(document).ready(function() {
		$("#backBtn").click(function() {
			document.backform.action="/";
			document.backform.method="GET";
			document.backform.submit();
		});
	});
</script>
</head>
<body>
	<form name="backform">
		<div class="container">
			<div class="p-2 mt-4"
				style="background-color: #e7e1f0; border: 2px solid #a277e6; border-radius: 8px;">
				<div class="row mt-2 mb-2">
					<div class="col-6 text-center text-danger">
						<img src="./resources/image/nodatafound.jpg">
					</div>
					<div class="col-6 text-left text-danger">
						<div>
							<span class="fs-4 d-flex justify-content-center">${msg}</span>
						</div>
						<div class="d-flex justify-content-center">
							<button class="btn btn-primary mt-2" id="backBtn">Back</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>