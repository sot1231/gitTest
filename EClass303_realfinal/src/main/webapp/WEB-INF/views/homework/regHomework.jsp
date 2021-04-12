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
	<form action="homework.reg" class="homework_reg_form" name="regHomeworkForm" onsubmit="return regHomeworkCheck();" method="post" enctype="multipart/form-data">
		<input name="token" type="hidden" readonly="readonly" value="${sessionScope.token }">
		<table class="homework_reg_tbl">
			<tr>
				<td class="homework_reg_td" >글 종류</td>
				<td>
					<select name="h_role">
						<option value="a">공지사항</option>
						<option value="h">과제</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="homework_reg_td" >제목</td>
				<td><input name="h_title" autocomplete="off"></td>
			</tr>
			<tr>
				<td class="homework_reg_td">시작 날짜</td>
				<td>
					<select name="startH_year">
						<c:forEach var="year" begin="2021" end="2022">
							<option>${year }</option>
						</c:forEach>
					</select> 년 
					<select name="startH_month">
						<c:forEach var="month" begin="1" end="12">
							<option>${month }</option>
						</c:forEach>
					</select> 월 
					<select name="startH_day">
						<c:forEach var="day" begin="1" end="31">
							<option>${day }</option>
						</c:forEach>
					</select> 일
				</td>
			</tr>
			<tr>
				<td class="homework_reg_td">종료 날짜</td>
				<td>
					<select name="endH_year">
						<c:forEach var="year" begin="2021" end="2022">
							<option>${year }</option>
						</c:forEach>
					</select> 년 
					<select name="endH_month">
						<c:forEach var="month" begin="1" end="12">
							<option>${month }</option>
						</c:forEach>
					</select> 월 
					<select name="endH_day">
						<c:forEach var="day" begin="1" end="31">
							<option>${day }</option>
						</c:forEach>
					</select> 일
				</td>
			</tr>
			<tr>
				<td class="homework_reg_td">내용</td>
				<td>
					<textarea name="h_content" maxlength="500"></textarea>
				</td>
			</tr>
			<tr>
				<td class="homework_reg_td">파일 첨부</td>
				<td>
					<input type="file" name="h_file">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="homework_reg_td2">
					<button class="homework_reg_but">글쓰기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>