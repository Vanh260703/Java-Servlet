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
<style type="text/css">
	.error{
		color:red;
	}
</style>
</head>
<body>
	<%
	
		String e_userName = request.getAttribute("e_userName") + "";
		String e_password = request.getAttribute("e_password") + "";
		String userName = (String)session.getAttribute("userName");
		
		if(e_userName.equals("null")){
			e_userName = "";
		}
		
		if(e_password.equals("null")){
			e_password = "";
		}
		
	%>

		<form action="login" method="POST" id="login-form">
	  <div class="mb-3">
	    <label class="form-label">Username:</label>
	    <input type="text" class="form-control" id="userName" name="userName" >
	    <div class="error" id="e_userName"><%= e_userName %></div>
	  </div>
	  <div class="mb-3">
	    <label  class="form-label">Password</label>
	    <input type="password" class="form-control" id="password" name="password" >
	    <div class="error" id="e_password"><%= e_password %></div>
	  </div>
	  <div class="mb-3 form-check">
	    <input type="checkbox" class="form-check-input" id="exampleCheck1">
	    <label class="form-check-label" for="exampleCheck1">Check me out</label>
	  </div>
	  <button type="submit" class="btn btn-primary">Đăng nhập</button>
	</form>
</body>
</html>