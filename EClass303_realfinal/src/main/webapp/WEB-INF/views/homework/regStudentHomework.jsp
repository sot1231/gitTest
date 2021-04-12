<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="student.homework.reg" class="homework_reg_form" name="studentRegHomeworkForm" onsubmit="return studentRegHomeworkCheck();" method="post" enctype="multipart/form-data">
		<input name="token" type="hidden" readonly="readonly" value="${sessionScope.token }">
		<table class="homework_reg_tbl">
			<tr>
				<td class="homework_reg_td">제목</td>
				<td><input name="s_title" autocomplete="off"></td>
			</tr>
			<tr>
				<td class="homework_reg_td">파일 첨부</td>
				<td>
					<input type="file" name="s_file">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="homework_reg_td2">
					<button class="homework_reg_but">과제 제출하기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>