<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
		<td>${sessionScope. loginMember. m_name }님 반갑습니다.</td>
		<td>
			<a href="go.update">
			<button>마이페이지</button>
			</a>
		</td>
		<td>
			<a href="member.logout">
				<button>로그아웃</button>
			</a>
		</td>
		</tr>
	</table>
</body>
</html>