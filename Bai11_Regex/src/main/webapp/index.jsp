<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color:red;
	}
</style>
</head>
<body>
	<%
		String e_soLuong = request.getAttribute("e_soLuong") + "";
		String e_soDienThoai = request.getAttribute("e_soDienThoai") + "";
		String e_email = request.getAttribute("e_email") + "";
		String value_soLuong = request.getAttribute("value_soLuong") + "";
		String value_soDienThoai = request.getAttribute("value_soDienThoai") + "";
		String value_email = request.getAttribute("value_email") + "";
		if(e_soLuong.equals("null")){
			e_soLuong = "";
		}
		if(e_soDienThoai.equals("null")){
			e_soDienThoai = "";
		}
		if(e_email.equals("null")){
			e_email = "";
		}
		
		
		if(value_soLuong.equals("null")){
			value_soLuong = "";
		}
		if(value_soDienThoai.equals("null")){
			value_soDienThoai = "";
		}
		if(value_email.equals("null")){
			value_email = "";
		}
		
		
		
	%>

	<form action="muaHang" method="POST">
		Số lượng cần mua: <input type="text" name="soLuong" required="required" value="<%= value_soLuong %>"/> <br/>
		<div class="error"><%= e_soLuong %></div>
		Số điện thoại: <input type= "text" name= "soDienThoai" value="<%= value_soDienThoai %>" required="required"/> <br/>
		<div class="error"><%= e_soDienThoai %></div>
		Email: <input type ="email" name="email" value="<%= value_email %>" required="required"/> <br/>
		<div class="error"><%= e_email %></div>
		<input type="submit" value="Mua Hàng">
	</form>
</body>
</html>