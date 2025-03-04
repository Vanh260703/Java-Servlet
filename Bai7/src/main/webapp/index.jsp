<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="trangDatHang.jsp" id = "myForm"  method = "get">
		<table>
			<tr>
				<td>
					<label>Số lượng đặt hàng:</label>
				</td>
				<td>
					<input type = "text" id = "quantity" name = "quantity">
				</td>
			</tr>
			<tr>
				<td>
					<label>Họ và tên:</label>
				</td>
				<td>
					<input type = "text" id = "name" name = "name">
				</td>
			</tr>
			<tr>
				<td>
					<label>Email:</label>
				</td>
				<td>
					<input type = "email" id = "email" name = "email">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type = "submit">Đặt hàng</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>