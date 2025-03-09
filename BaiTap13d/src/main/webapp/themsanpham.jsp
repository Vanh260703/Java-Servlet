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

	form {
    max-width: 500px;
    margin: 20px auto;
    padding: 20px;
    background: #f8f9fa;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}

	.mb-3 {
	    margin-bottom: 15px;
	}
	
	.form-label {
	    font-weight: bold;
	    color: #333;
	}
	
	.form-control, textarea {
	    width: 100%;
	    padding: 8px;
	    border: 1px solid #ccc;
	    border-radius: 5px;
	    font-size: 16px;
	}
	
	textarea {
	    height: 120px;
	    resize: none;
	}
	
	input:focus, textarea:focus {
	    border-color: #007bff;
	    outline: none;
	    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
	}
	
	span{
		color:red;
	}
	
	.error {
    color: red;
    font-size: 14px;
    margin-top: 5px;
	}
</style>
</head>
<body>
	<% 
		String userName = (String) session.getAttribute("userName");
		String e_product = request.getAttribute("e_product") + "";
		String e_quantity = request.getAttribute("e_quantity") + "";
		String e_importPrice = request.getAttribute("e_importPrice") + "";
		String e_sellingPrice = request.getAttribute("e_sellingPrice") + "";
		
		if(e_product.equals("null")){
			e_product = "";
		}
		
		if(e_quantity.equals("null")){
			e_quantity = "";
		}
		
		if(e_importPrice.equals("null")){
			e_importPrice = "";
		}
		
		if(e_sellingPrice.equals("null")){
			e_sellingPrice = "";
		}
		
		String value_product = request.getAttribute("value_prodcut") + "";
		String value_quantity = request.getAttribute("value_quantity") + "";
		String value_importPrice = request.getAttribute("value_importPrice") + "";
		String value_sellingPrice = request.getAttribute("value_sellingPrice") + "";
		
		
		if(value_product.equals("null")){
			value_product = "";
		}
		
		if(value_quantity.equals("null")){
			value_quantity = "";
		}
		
		if(value_importPrice.equals("null")){
			value_importPrice = "";
		}
		
		if(value_sellingPrice.equals("null")){
			value_sellingPrice = "";
		}
	
		
	%>
	
	<div id="user-login">
	<p><%= userName %></p>
	  <form action="logout.jsp">
		<button type="submit">Đăng xuất</button>
	</form>
	</div>

	<form action="addProduct" method="GET">
		<div class="mb-3">
			<label class="form-label">Sản phẩm muốn thêm<span>*</span></label>
			<input type="text" class="form-control" id="product" name="product" value ="<%= value_product %>">
			<div class="error"><%= e_product %></div>
		</div>
		<div class="mb-3">
			<label class="form-label">Số lượng sản phẩm<span>*</span></label>
			<input type="text" class="form-control" id="quantity" name="quantity" value ="<%= value_quantity %>">
			<div class="error"><%= e_quantity %></div>
		</div>
		<div class="mb-3">
			<label class="form-label">Giá nhập<span>*</span></label>
			<input type="text" class="form-control" id="import_price" name="import_price" value ="<%= value_importPrice %>">
			<div class="error"><%= e_importPrice %></div>
		</div>	
		<div class="mb-3">
			<label class="form-label">Giá bán<span>*</span></label>
			<input type="text" class="form-control" id="selling_price" name="selling_price" value ="<%= value_sellingPrice %>">
			<div class="error"><%= e_sellingPrice %></div>
		</div>
		<div class="mb-3">
			<label class="form-label">Mô tả sản phẩm</label>
			<textarea rows="10" cols="20" name="describe"></textarea>
		</div>
		<div class ="mb-3">
			<button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
		</div>
	</form>
</body>
</html>