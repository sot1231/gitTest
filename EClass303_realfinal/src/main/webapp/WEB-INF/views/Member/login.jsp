<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginTbl">
	<form action="member.login" method="POST">
		<tr>
			<td>
				<input name="m_id" placeholder="ID">  
				<input name="m_pw" placeholder="PW" type="password">
				<button>Login</button>
			</td>
	</form>
			<td>
				<a href="go.reg"><button>회원가입</button></a>
				<a href="go.find"><button>ID/PW 찾기</button></a>
			</td>
		</tr>
	</table>
</body>
</html>