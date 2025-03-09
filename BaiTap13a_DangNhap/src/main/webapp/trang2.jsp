
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username =(String) session.getAttribute("username");
	%>
	
	<h1>Xin chào <%= username %></h1>
	<br/>
	<h1>ĐÂY LÀ TRANG CHÀO 2</h1>
</body>
</html>
