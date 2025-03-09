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
</head>
<body>
	<% 
		String product = (String) session.getAttribute("product");
		String quantity = (String) session.getAttribute("quantity");
		String importPrice = (String) session.getAttribute("importPrice");
		String sellingPrice = (String) session.getAttribute("sellingPrice");
		String describe = (String) session.getAttribute("describe");
		
		if(describe == null){
			describe = "";
		}
	%>

	<!--  HTML -->
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Tên sản phẩm</th>
		      <th scope="col">Số lượng</th>
		      <th scope="col">Giá nhập</th>
		      <th scope="col">Giá bán</th>
		      <th scope="col">Mô tả(nếu có)</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row"><%= product %></th>
		      <td><%= quantity %></td>
		      <td><%= importPrice %></td>
		      <td><%= sellingPrice %></td>
		      <td><%= describe %></td>
		    </tr>
		  </tbody>
		</table>
	
	<!--  End HTML -->
	
	
	<script type="text/javascript">
		alert("Thêm sản phẩm thành công");
	</script>
</body>
</html>