<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${l.m_role eq 's'}">
		<c:if test="${check eq 'x'}">
		
			<div class="attend_title">
			<input class="token" name="token" type="hidden" readonly="readonly" value="${sessionScope.token }">
				출 석 체 크
			</div>
			
			<div class="check_button">
				<button onclick="checkAttendance();">출 석 체 크 하 기</button>
			</div>
		</c:if>
		<table class="attend_table">
			<tr>
				<td class="attend_date_td"><fmt:formatDate value="${mon }"
						pattern="yyyy.MM.dd (E)" /></td>
				<td class="attend_date_td"><fmt:formatDate value="${tue }"
						pattern="yyyy.MM.dd (E)" /></td>
				<td class="attend_date_td"><fmt:formatDate value="${wen }"
						pattern="yyyy.MM.dd (E)" /></td>
				<td class="attend_date_td"><fmt:formatDate value="${thu }"
						pattern="yyyy.MM.dd (E)" /></td>
				<td class="attend_date_td"><fmt:formatDate value="${fri }"
						pattern="yyyy.MM.dd (E)" /></td>
			</tr>
			<tr>
				<td class="attend_img_td"><img width="80px"
					src="resources/Img/${monA }"></td>
				<td class="attend_img_td"><img width="80px"
					src="resources/Img/${tueA }"></td>
				<td class="attend_img_td"><img width="80px"
					src="resources/Img/${wenA }"></td>
				<td class="attend_img_td"><img width="80px"
					src="resources/Img/${thuA }"></td>
				<td class="attend_img_td"><img width="80px"
					src="resources/Img/${friA }"></td>
			</tr>
		</table>
	</c:if>

	<c:if test="${l.m_role eq 't'}">
		<table class="attend_table">
			<tr>
				<td class="attend_date_td" align="center"><fmt:formatDate
						value="${mon }" pattern="yyyy.MM.dd (E)" /></td>
				<td class="attend_date_td" align="center"><fmt:formatDate
						value="${tue }" pattern="yyyy.MM.dd (E)" /></td>
				<td class="attend_date_td" align="center"><fmt:formatDate
						value="${wen }" pattern="yyyy.MM.dd (E)" /></td>
				<td class="attend_date_td" align="center"><fmt:formatDate
						value="${thu }" pattern="yyyy.MM.dd (E)" /></td>
				<td class="attend_date_td" align="center"><fmt:formatDate
						value="${fri }" pattern="yyyy.MM.dd (E)" /></td>
			</tr>
			<tr>
				<td class="attend_text_td1">${countMon }</td>
				<td class="attend_text_td1">${countTue }</td>
				<td class="attend_text_td1">${countWen }</td>
				<td class="attend_text_td1">${countThu }</td>
				<td class="attend_text_td1">${countFri }</td>
			</tr>
			<tr>
				<td class="attend_text_td2">
				<c:if test="${neMon !=null}">
					<h1 class="attend_text_h1">출석 안한 학생</h1> <br>
						<c:forEach var="ne1" items="${neMon }">
					${ne1.m_name } <br>
						</c:forEach>
					</c:if></td>
				<td class="attend_text_td2"><c:if test="${neTue !=null}">
					<h1 class="attend_text_h1">출석 안한 학생</h1> <br>
						<c:forEach var="ne1" items="${neTue }">
					${ne1.m_name } <br>
						</c:forEach>
					</c:if></td>
				<td class="attend_text_td2"><c:if test="${neWen !=null}">
					<h1 class="attend_text_h1">출석 안한 학생</h1> <br>
						<c:forEach var="ne1" items="${neWen }">
					${ne1.m_name } <br>
						</c:forEach>
					</c:if></td>
				<td class="attend_text_td2"><c:if test="${neThu !=null}">
					<h1 class="attend_text_h1">출석 안한 학생</h1> <br>
						<c:forEach var="ne1" items="${neThu }">
					${ne1.m_name } <br>
						</c:forEach>
					</c:if></td>
				<td class="attend_text_td2"><c:if test="${neFri !=null}">
					<h1 class="attend_text_h1">출석 안한 학생</h1> <br>
						<c:forEach var="ne1" items="${neFri }">
					${ne1.m_name } <br>
						</c:forEach>
					</c:if></td>
			</tr>
		</table>
	</c:if>


</body>
</html>