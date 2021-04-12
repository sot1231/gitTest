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
	<table id="wrapHomework" class="homework_tbl">
		<tr class="homework_title_tr">
			<td class="homework_title_td" colspan="3">과제 제출 게시판</td>
		</tr>
		<tr class="homework_banner_tr">
			<td class="homework_banner_td" colspan="3">
				<select class="homework_banner_select" id="changeCategory" onchange="changeCategory();">
					<option disabled="disabled" selected="selected">카테고리</option>
					<option value="a">공지사항</option>
					<option value="h">과제</option>
				</select>
				<select class="homework_banner_select" id="changePerPage" onchange="changePerPage();">
					<option disabled="disabled" selected="selected">게시글 갯수</option>
					<option value="5">5개씩 보기</option>
					<option value="10">10개씩 보기</option>
					<option value="15">15개씩 보기</option>
				</select>
				<button id="writeHomework" class="homework_banner_select" onclick="goRegHomework();">글쓰기</button>
				<input id="checkMemberRole" type="hidden" readonly="readonly" value="${sessionScope.loginMember.m_role}">
			</td>
		</tr>
		<tr class="homework_content_top_tr">
			<td class="homework_content_top_td1">카테고리</td>
			<td class="homework_content_top_td1">글 제목</td>
			<td class="homework_content_top_td2">제출기한 / 등록날짜</td>
		</tr>
		<c:forEach var="hw" items="${homeworks }">
			<tr class="homework_content_tr">
				<td>
					<c:if test="${hw.h_role eq 'a'}">공지사항</c:if>
					<c:if test="${hw.h_role eq 'h'}">과제</c:if>
				</td>
				<td>
					<a href="homework.detail?h_seq=${hw.h_seq }">${hw.h_title }</a>
				</td>
				<td>
				<c:if test="${hw.h_role eq 'h'}">
					<fmt:parseDate value="${hw.h_startdate }" var="dateFmt" pattern="yyyyMMdd"/>
					<fmt:formatDate value="${dateFmt}" pattern="yyyy년 MM월 dd일 부터"/>
	
					<fmt:parseDate value="${hw.h_enddate } " var="dateFmt" pattern="yyyyMMdd"/>
					 ~ <fmt:formatDate value="${dateFmt}" pattern="yyyy년 MM월 dd일 까지"/>
				</c:if>
				<c:if test="${hw.h_role eq 'a' }">
					<fmt:formatDate value="${hw.h_date }" pattern="yyyy년 MM월 dd일 hh시mm분"/>
				</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr class="homework_paging_tr">
			<td id="homeworkPageTd" class="homework_paging_td" colspan="3">
				<input id="allHomeworkPageCount" type="hidden" readonly="readonly" value="${allHomeworkPageCount }">
				<c:forEach var="page" begin="1" end="${allHomeworkPageCount }">
					<a href="homework.change?page=${page }" >${page }</a>				
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td class="homework_paging_td" colspan="3">
				<input id="serachHomework" placeholder="검색어 입력" autocomplete="off">
				<button onclick="searchHomework();">검색</button>
			</td>
		</tr>
	</table>
</body>
</html>