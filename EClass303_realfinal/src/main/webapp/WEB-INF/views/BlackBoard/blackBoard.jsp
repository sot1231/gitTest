<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/blackBoard.css">
<script type="text/javascript" src="http://192.168.56.1:9999/socket.io/socket.io.js"></script>
</head>
<body>
	<table id="blackBoardTbl">
		<tr>
			<th colspan="2">칠판</th>
		</tr>
		<tr>
			<td>
				<input value="black" style="outline: none;" id="bruchColorInput"></td>
			<td align="right" id="bbNotice">* 오른쪽 마우스 버튼을 클릭하면 이미지가 저장됩니다.</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><canvas id="paper" width="900px" height="500px;"></canvas></td>
		</tr>
	</table>
</body>
</html>