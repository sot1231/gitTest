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
	<c:if test="${sessionScope. loginMember !=null }">
		<form action="write.snscontent" method="post" name="writeSNSForm" onsubmit="return WriteSNSCheck();">
			<table id="wrtieSns">
				<tr>
					<td align="center" id="snsTextarea">
						<textarea name="s_content" placeholder="내용을 입력하세요"></textarea> 
						<input name="token" type="hidden" readonly="readonly" value="${sessionScope.token }">
					</td>
					<td>
						<button>글쓰기</button> 
						<input name="token" type="hidden" readonly="readonly" value="${sessionScope.token }">
					</td>
				</tr>
			</table>
		</form>
	</c:if>
	<form action="search.snscontent" method="post" name="searchSNSForm" onsubmit="return SearchSNSCheck();">
		<table id="snsSearchTbl">
			<tr>
				<td>
					<input name="snsSearch">
				</td>
				<td>
					<button>찾기</button>
				</td>
			</tr>
		</table>
	</form>
	<c:if test="${currentPage!=1 }">
		<table id="leftPage">
			<tr>
				<td class="nextSNS">
				<a href="change.snspage?p=${currentPage-1 }"><img src="resources/menuIcon/left.png" width="60px" height="60px"></a></td>
			</tr>
		</table>
	</c:if>
	<c:if test="${currentPage!=allPageCount }">
		<table id="rightPage">
			<tr>
				<td class="nextSNS">
				<a href="change.snspage?p=${currentPage+1 }"><img src="resources/menuIcon/right.png" width="60px" height="60px"></a></td>
			</tr>
		</table>
	</c:if>
	<table id="sns">
		<tr>
			<td align="center"><c:forEach var="sc" items="${snsContents }">
					<table class="snsContents">
						<tr>
							<td id="snsWriter" colspan="2"><img src="resources/profileImg/${sc.m_img }">${sc.m_id }</td>
						</tr>
						<tr>
							<td id="snsWriteTime" colspan="2">
								<fmt:formatDate value="${sc.s_date }" type="both" dateStyle="long" timeStyle="short" /></td>
						</tr>
						<tr>
							<td id="snsTxt" colspan="2" align="center">${sc.s_content }</td>
						</tr>
						<tr>
							<td class="snsRelyArea" align="right" colspan="2">
								<c:forEach var="sr" items="${sc.s_replys}">
									[ ${sr.sr_writer } ] &nbsp; &nbsp;  ${sr.sr_reply } &nbsp;
									<a class="replyDate"> (<fmt:formatDate value="${sr.sr_date }" type="both" dateStyle="short" timeStyle="short" />) </a>
									<c:if test="${sr.sr_writer==sessionScope.loginMember.m_id || sessionScope.loginMember.m_id=='teacher' }">
										<button onclick="deleteSNSReply(${sr.sr_num });">삭제</button>
									</c:if>
									<br>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td align="center" id="writeReply" colspan="2">
							<c:if test="${sessionScope.loginMember !=null}">
									<form action="write.snsreply" method="post" name="writeSNSReplyForm" onsubmit="return WriteSNSReplyCheck(this);">
										<input name="sr_s_num" value="${sc.s_num }" type="hidden">
										<input name="sr_writer" value="${sessionScope.loginMember.m_id }" readonly="readonly" type="hidden">
										<input name="sr_reply" id="replyWrite">
										<button>댓글 쓰기</button>
										<input name="token" type="hidden" readonly="readonly" value="${sessionScope.token }">
									</form>
								</c:if>
							</td>
						</tr>

						<tr>
							<c:if test="${sc.m_id==sessionScope.loginMember.m_id || sessionScope.loginMember.m_id=='teacher' }">
								<td align="right" id="snsUpdate" class="snsUpdateDelete">
									<button onclick="deleteSNS(${sc.s_num });">삭제</button>
								</td>
								<td align="center" class="snsUpdateDelete">
									<button onclick="updateSNS(${sc.s_num }, '${sc.s_content }');">수정</button>
								</td>
							</c:if>
						</tr>
					</table>
				</c:forEach>
			</td>
		</tr>
	</table>






</body>
</html>