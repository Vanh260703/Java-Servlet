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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String quantity = request.getParameter("quantity");
		int moneySpend = 0;
	%>
	
	<%
		try{
			int newQuantity = Integer.parseInt(quantity);
			moneySpend = newQuantity * 5;
		}catch(Exception e){
		}
	%>
	<h1>Xác nhận đặt hàng</h1>
	<p>Xin chào bạn <%= name %> đã đặt <%= quantity %> sản phẩm</p>
	<p>Bạn sẽ nhận được thông báo qua email: <%= email %></p>
	<p>Số tiền bạn phải trả: <%= moneySpend %> $</p>
</body>
</html>