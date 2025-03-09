<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #user-login{
    position: fixed;
    top: 10px;
    right: 10px;
    background: #f8f9fa;
    padding: 10px 15px;
    border-radius: 10px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    display: flex;
    align-items: center;
    gap: 10px;
  }

  #user-login p {
    margin: 0;
    font-weight: bold;
    color: #333;
  }

  #user-login button {
    background: #dc3545;
    color: white;
    border: none;
    padding: 5px 10px;
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
  }

  #user-login button:hover {
    background: #c82333;
  }
</style>
</head>
<body>
<%
	String userName = (String) session.getAttribute("userName");

	if(userName == null){
		response.sendRedirect("login.jsp");
		return;
	}
%>

<h1>Chào mừng bạn đã đến với trang chủ của chúng tôi</h1>
<div id="user-login">
	<p><%= userName %></p>
	  <form action="logout.jsp">
		<button type="submit">Đăng xuất</button>
	</form>
</div>

<a href="themsanpham.jsp">Vui lòng nhấn vào đây để thêm sản phẩm! </a>
	<script type="text/javascript">
		alert("Chúc mừng bạn đã đăng nhập thành công!");
	</script>
</body>
</html>