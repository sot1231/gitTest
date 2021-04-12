<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/elcassJQuery.js"></script>
<script type="text/javascript" src="resources/js/homeworkBoard.js"></script>
<script type="text/javascript" src="resources/js/attendance.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/RegPage.css">
<link rel="stylesheet" href="resources/css/snsBoard.css">
<link rel="stylesheet" href="resources/css/homework.css">
<link rel="stylesheet" href="resources/css/attendance.css">
<link href='resources/css/main.css' rel='stylesheet' />

</head>
<body>
	<table id="indexTbl">
		<tr>
			<td id="titleArea" align="center" rowspan="2">
				<a href="index.go">3학년 3반 E-Class</a>
			</td>
			<c:if test="${sessionScope. loginMember !=null }">
				<td id="menuArea" align="right">
					<a href="go.attendance"> 
						<img alt="" src="resources/menuIcon/attendance.png" class="menuIcon">
					</a> 
					<a href="go.snsboard"> 
						<img alt="" src="resources/menuIcon/board.png" class="menuIcon">
					</a> 
					
					<a href="homework.go"> 
						<img alt="" src="resources/menuIcon/homework.png" class="menuIcon">
					</a>
					<a href="go.blackboard"> 
						<img alt="" src="resources/menuIcon/blackBoard.png" class="menuIcon">
					</a>
				</td>
			</c:if>
		</tr>

		<tr>
			<td id="LoginArea" align="right"><jsp:include
					page="${LoginPage}"></jsp:include></td>
		</tr>
		<tr>
			<td id="resultArea" align="right" colspan="2">${result }</td>
		</tr>


		<tr>
			<td id="contentsArea" colspan="2" align="center"><jsp:include
					page="${contentPage }"></jsp:include></td>
		</tr>

	</table>

</body>
</html>