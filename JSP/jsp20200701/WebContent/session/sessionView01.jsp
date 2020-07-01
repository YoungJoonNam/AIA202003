<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String userName = (String) session.getAttribute("username");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Session의 속성으로 지정한 데이터 <br>
	username : <%= userName %><br>
	<a href="sessionView02.jsp">SessionView02</a>
</body>
</html>