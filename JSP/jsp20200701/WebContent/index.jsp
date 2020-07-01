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

<link rel="stylesheet" href="./css/default.css">

<style>
	
</style>
</head>
<body>
	<%@ include file="./include/header.jsp" %>
	
	<h1 id="header">Open Project</h1>
	<ul id="nav">
		<li><a href="member/memberRegForm.html">회원가입</a></li>
		<li><a href="member/loginForm.jsp">로그인</a></li>
		<li><a href="member/mypage/myPage.jsp">마이페이지</a></li>
		<li><a href="guestBook/list.jsp">방명록(비회원)</a></li>
		<li><a href="board/list.jsp">방명록(회원제)</a></li>
	</ul>
	<div>
		index
		
		Session의 속성으로 지정한 데이터 <br>
		username : <%= userName %> <br>	
		
		<%
		
		session.setAttribute("username", "KING");
		
		%>
		
		<a href="./session/sessionView01.jsp">Session</a>
		
	</div>
	
	<%@ include file="./include/footer.jsp" %>
	<footer>
		Open Project @2020
	</footer>
</body>
</html>