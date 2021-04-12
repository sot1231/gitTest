<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.slider').bxSlider({
			mode : 'fade',
			captions : true,
			slideWidth : 600,
			auto : true,
			autoDelay : 300,
			controls : false
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="slider">

		<div>
			<img src="resources/Img/1.jpg">
		</div>

		<div>
			<img src="resources/Img/2.jpg">
		</div>

		<div>
			<img src="resources/Img/3.jpg">
		</div>

	</div>
</body>
</html>