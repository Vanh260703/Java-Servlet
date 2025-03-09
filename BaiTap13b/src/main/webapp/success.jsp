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
		String userName =(String) session.getAttribute("userName");
	
	%>
	
	<h1>Xin chào <%= userName %>!</h1>
	<form action="logout.jsp">
	<button type="submit" >Đăng xuất</button>
	</form>
</body>
</html>