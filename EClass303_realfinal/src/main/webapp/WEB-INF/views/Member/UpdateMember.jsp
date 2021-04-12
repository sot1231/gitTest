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

	<table id="memberRegTbl">
		<form name="updateFrom" action="member.update" method="post" enctype="multipart/form-data" onsubmit="return Updatecheck();">
		<tr>
			<th colspan="2">[ 마이페이지 ]</th>
		</tr>
		<tr>
			<td align="center">ID</td>
			<td>
				<input name="m_id" id="m_id" autocomplete="none" readonly="readonly" value="${sessionScope. loginMember. m_id }">
			</td>
		</tr>
		<tr>
			<td align="center">PW</td>
			<td>
				<input name="m_pw" type="password" value="${sessionScope. loginMember. m_pw }">
			</td>
		</tr>
		<tr>
			<td align="center">PW 확인</td>
			<td>
				<input name="m_pw2" type="password">
			</td>
		</tr>
		<tr>
			<td align="center">이름</td>
			<td>
				<input name="m_name" autocomplete="none" value="${sessionScope. loginMember. m_name }">
			</td>
		</tr>
		<tr>
			<td align="center">생년월일</td>
			<td>
				<select name="reg_year">
					<option>${yyyy }</option>
					<c:forEach var="year" begin="1960" end="2015">
						<option>${year }</option>
					</c:forEach>
			</select> 년 
			<select name="reg_month">
					<option>${mm }</option>
					<c:forEach var="month" begin="1" end="12">
						<option>${month }</option>
					</c:forEach>
			</select> 월 
			<select name="reg_day">
					<option>${dd }</option>
					<c:forEach var="day" begin="1" end="31">
						<option>${day }</option>
					</c:forEach>
			</select> 일</td>
		</tr>
		<tr>
			<td align="center" rowspan="3">주소</td>
			<td>
				<input id="addr1" name="addr1" placeholder="우편번호" readonly="readonly" value="${addr1 }">
			</td>
		</tr>
		<tr>
			<td>
				<input id="addr2" name="addr2" placeholder="주소" readonly="readonly" value="${addr3 }">
			</td>
		</tr>
		<tr>
			<td>
				<input name="addr3" placeholder="상세주소" autocomplete="none" value="${addr2 }">
			</td>
		</tr>
		<tr>
			<td align="center">메일</td>
			<td>
				<input name="reg_mail" autocomplete="none" value="${sessionScope. loginMember. m_mail }"> 
				<select name="reg_domain">
					<option value="">직접입력</option>
					<option value="@naver.com">네이버</option>
					<option value="@daum.net">다음</option>
					<option value="@gmail.com">구글</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="center">
				<img alt="" src="resources/profileImg/${sessionScope. loginMember. m_img }" width="60px" height="60px">
			</td>
			<td>
				<input type="file" name="reg_img">
			</td>
		</tr>
		<tr>
			<td align="center" id="regBtnArea" colspan="2">
				<button>정보 수정</button>
				<input name="token" type="hidden" readonly="readonly" value="${sessionScope.token }">
			</td>
		</tr>
	</form>
		<tr>
			<td colspan="2" align="right">
			<button onclick="deleteMember();" name="out">회원 탈퇴</button></td>
		</tr>
	</table>
</body>
</html>