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
	<table id="findTbl">
		<tr>
			<th class="findTitle" id="findIDTitle">아이디 찾기</th>
			<th class="findPW" id="findPWTitle">비밀번호 찾기</th>
		</tr>
		<tr>
			<td>
				<form action="find.ID">
					<table class="findIDs" id="findIDTbl">
						<tr>
							<td align="center">이름</td>
							<td align="center"><input name="m_name" autocomplete="none">
							</td>
						</tr>

						<tr>
							<td align="center">메일 주소</td>
							<td align="center"><input name="m_mail" autocomplete="none">
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<button>찾기</button>
							</td>
						</tr>
					</table>
				</form>
			</td>

			<td>
				<form action="find.PW">
					<table class="findPW" id="findPWTbl">
						<tr>
							<td align="center">아이디</td>
							<td><input name="m_id" autocomplete="none"></td>
						</tr>
						<tr>
							<td align="center">메일 주소</td>
							<td><input name="m_mail" autocomplete="none"> <input
								name="token" type="hidden" readonly="readonly"
								value="${sessionScope.token }"></td>
						</tr>
						<tr>
							<td align="center" colspan="2"><button>임시 비밀번호 받기</button></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<c:if test="${foundID.m_id!=null}">
				<td align="center" class="findIDs" id="ResultID">아이디는<a>${foundID.m_id}</a>
					입니다
				</td>
			</c:if>
			<td></td>
		</tr>
	</table>
</body>
</html>