<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="homework_detail_tbl">
		<tr class="homework_detail_title_tr">
			<td class="homework_detail_title_td" colspan="2">${hm.h_title }</td>
		</tr>
		<tr>	
			<td class="homework_detail_banner_td" colspan="2">
				<input id="checkMemberRole" type="hidden" readonly="readonly" value="${sessionScope.loginMember.m_role}">
				<input id="checkHSeq" type="hidden" readonly="readonly" value="${hm.h_seq}">
				<input id="token" name="token" type="hidden" readonly="readonly" value="${sessionScope.token }">
				<button onclick="goUpdatePage();">글 수정</button>
				<button onclick="deleteHomework();">글 삭제</button>
			</td>
		</tr>
		<tr class="homework_detail_content_top_tr">
			<td style="width: 30%">작성자</td>
			<td style="width: 70%">제출날짜 / 작성날짜</td>
		</tr>
		<tr class="homework_detail_content_top_tr2">
			<td>${hm.h_writer }</td>
			<td>
				<c:if test="${hm.h_role eq 'h'}">
					<fmt:parseDate value="${hm.h_startdate }" var="dateFmt" pattern="yyyyMMdd"/>
					<fmt:formatDate value="${dateFmt}" pattern="yyyy년 MM월 dd일 부터"/>
	
					<fmt:parseDate value="${hm.h_enddate } " var="dateFmt" pattern="yyyyMMdd"/>
					 ~ <fmt:formatDate value="${dateFmt}" pattern="yyyy년 MM월 dd일 까지"/>
				</c:if>
				<c:if test="${hm.h_role eq 'a' }">
					<fmt:formatDate value="${hm.h_date }" pattern="yyyy년 MM월 dd일 hh시mm분"/>
				</c:if>
			</td>
		</tr>
		<tr class="homework_detail_content_tr">
			<td colspan="2">${hm.h_content }</td>
		</tr>
		<tr>
			<td class="homework_detail_content_bot_tr" colspan="2">
				<a href="resources/profileImg/${hm.h_file }" download>과제 다운로드</a>
				<c:if test="${hm.h_role eq 'h'}">
					<button onclick="goStudentPage();">과제 제출하기</button>
				</c:if>
			</td>
		</tr>
	</table>
	<c:if test="${hm.h_role eq 'h'}">
		<table class="homework_detail_tbl">
			<tr class="homework_detail_content_top_tr">
				<td>이름</td>
				<td>제출시간</td>
				<td>과제</td>
				<td>과제 제출 기한</td>
			</tr>
			<c:forEach var="shw" items="${studentHomeworks }">
				<tr class="homework_detail_content_top_tr">
					<td style="width: 20%">${shw.s_name }</td>
					<td style="width: 40%">
						<fmt:formatDate value="${shw.s_date }" pattern="yyyy년 MM월 dd일 hh시mm분"/>
					</td>
					<td style="width: 20%">
						<c:if test="${l.m_role eq 't' }">
							<a href="resources/profileImg/${shw.s_file }" download>과제 다운로드</a>
						</c:if>
						<c:if test="${l.m_role eq 's' }">
							학생은 다운로드 불가
						</c:if>
					</td>
					<td style="width: 20%">
						<c:if test="${shw.s_submit eq 'l' }">
							지각
						</c:if>
						<c:if test="${shw.s_submit eq 'o' }">
							정상 제출
						</c:if>
					</td>			
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>