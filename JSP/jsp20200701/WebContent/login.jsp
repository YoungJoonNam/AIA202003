<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<h1>전송 결과</h1>
	<hr>
	<table border="1" cellspacing="0">
		<tr>
			<td>아이디(이메일)</td>
			<td> <%= request.getParameter("id") %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td> <%= request.getParameter("pw") %></td>
		</tr>		
		<tr>
			<td>요청 메서드</td>
			<td> <%= request.getMethod() %></td>
		</tr>	
		
	</table>

</body>
</html>