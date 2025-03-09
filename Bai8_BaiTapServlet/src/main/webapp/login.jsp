<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="login" method ="POST">
		<table>
			<tbody>
				<tr>
					<td>Tên đăng nhập</td>
					<td>
						<input type ="text" name ="tenDangNhap"/>
					</td>
				</tr>
				<tr>
					<td>Mật khẩu</td>
					<td>
						<input type ="password" name ="password"/>
					</td>
				</tr>
				<tr>
					<td colspan ="2">
						<button type ="submit">Đăng nhập</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>