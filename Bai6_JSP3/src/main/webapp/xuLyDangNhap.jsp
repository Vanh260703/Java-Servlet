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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
	%>
	
	<%
		if(userName.equalsIgnoreCase("tung") && password.equals("123")){
			
	%>
		Bạn đã đăng nhập thành
	<%
		}else{
	%>	
		Bạn đã điền sai mật khẩu hoặc tài khoản
	<%
		}
	%>	