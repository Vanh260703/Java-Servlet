<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Boostrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<!-- End Boostrap -->
<!-- CSS -->
<link rel="stylesheet" href="login.css">
<!-- End CSS -->
</head>
<body>
	<div claas ="container">
		<form action="datMuaHang.jsp" method = "GET">
			<div class = "form-input">
				<input type = "text" id ="newUser" name = "email" placeholder="Số di động hoặc email">
			</div>
			<div class = "form-input">
				<input type = "password" id = "password" name = "password" placeholder="Mật khẩu">	
			</div>
			<div class = "form-input">
				<input type = "text" id = "fullName" name ="fullName" placeholder="Tên đầy đủ">
			</div>
			<div class = "form-input">
				<input type = "text" id = "userName" name = "username" placeholder="Tên người dùng">
			</div>
			<div class = "form-button">
				<button class = "btn btn-primary" type = "submit" name = "register" onclick = "registerCheck()">Đăng ký</button>
			</div>
			
		</form>
	</div>
	<script type="text/javascript" src="login.js"></script>
</body>
</html>