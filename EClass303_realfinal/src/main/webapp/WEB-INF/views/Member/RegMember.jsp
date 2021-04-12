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
	<form name="reg" action="member.reg" method="post"
		enctype="multipart/form-data" onsubmit="return Regcheck();">
		<table id="memberRegTbl">
			<tr>
				<th colspan="2">[ 회원 가입 ]</th>
			</tr>
			<tr>
				<td align="center">ID</td>
				<td><input name="m_id" id="m_id" autocomplete="none"></td>
			</tr>
			<tr>
				<td align="center">PW</td>
				<td><input name="m_pw" type="password"></td>
			</tr>
			<tr>
				<td align="center">PW 확인</td>
				<td><input name="m_pw2" type="password"></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input name="m_name" autocomplete="none"></td>
			</tr>
			<tr>
				<td align="center">생년월일</td>
				<td>
					<select name="reg_year">
						<c:forEach var="year" begin="1960" end="2015">
							<option>${year }</option>
						</c:forEach>
					</select> 년 
					<select name="reg_month">
						<c:forEach var="month" begin="1" end="12">
							<option>${month }</option>
						</c:forEach>
					</select> 월 
					<select name="reg_day">
						<c:forEach var="day" begin="1" end="31">
							<option>${day }</option>
						</c:forEach>
					</select> 일
				</td>
			</tr>
			<tr>
				<td align="center" rowspan="3">주소</td>
				<td>
				<input id="addr1" name="addr1" placeholder="우편번호" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>
					<input id="addr2" name="addr2" placeholder="주소"readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>
					<input name="addr3" placeholder="상세주소" autocomplete="none">
					<input name="token" type="hidden" readonly="readonly" value="${sessionScope.token }">
				</td>
			</tr>
			<tr>
				<td align="center">메일</td>
				<td>
				<input class="mail_input" name="reg_mail" autocomplete="none"> 
				<select id="mail_select" name="reg_domain">
						<option  value="">직접입력</option>
						<option  value="@naver.com">네이버</option>
						<option  value="@daum.net">다음</option>
						<option  value="@gmail.com">구글</option>
				</select>
					<input class="mail_check_input" disabled="disabled">
					<div class="mail_check_button">인증메일 보내기</div>
					<span id="mail_check_input_box_warn"></span>
				</td>
			</tr>
			<tr>
				<td align="center">프로필 사진</td>
				<td>
				<input type="file" name="reg_img">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="regBtnArea">
					<button>가입</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>