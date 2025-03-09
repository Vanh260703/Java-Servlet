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
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
	%>
	
	<h1>ĐẶT HÀNG THÀNH CÔNG</h1>
	
	<p>Cảm ơn <%= fullName %> đã đặt hàng. Bạn sẽ nhận được thư confirm vào email: <%= email %>!</p>
</body>
</html>