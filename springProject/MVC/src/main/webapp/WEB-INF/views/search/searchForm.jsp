<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	�˻� ${searchType}
	<select>
	<c:forEach items="${searchType }" var="type">
		<option value="${type.tno }">${type.type }</option>
	</c:forEach>
	</select>





</body>
</html>