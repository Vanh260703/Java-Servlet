<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content=" HTML5 Title">
 <meta name="author" content="Guru99">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
	<style type="text/css">
		.rq{
			color:red;
		}
		
		.error{
			color:red;
		}
		
	</style>
</head>
<body>
<%
	String e_maSanPham = request.getAttribute("e_maSanPham") +"";
	String e_tenSanPham = request.getAttribute("e_tenSanPham") +"";
	String e_giaNhap = request.getAttribute("e_giaNhap") +"";
	String e_giaBan = request.getAttribute("e_giaBan") +"";
	if(e_maSanPham == null || e_maSanPham.equals("null")){
		e_maSanPham = "";
	}
	if(e_tenSanPham == null || e_tenSanPham.equals("null")){
		e_tenSanPham = "";
	}
	if(e_giaNhap == null || e_giaNhap.equals("null")){
		e_giaNhap = "";
	}
	if(e_giaBan == null || e_giaBan.equals("null")){
		e_giaBan = "";
	}
	String value_maSanPham = request.getAttribute("value_maSanPham") + "";
	String value_tenSanPham = request.getAttribute("value_tenSanPham") + "";
	String value_giaBan = request.getAttribute("value_giaBan") + "";
	String value_giaNhap = request.getAttribute("value_giaNhap") + "";
	String value_hanSuDung = request.getAttribute("value_hanSuDung") + "";
	String value_vat = request.getAttribute("value_vat") + "";
	String value_moTa = request.getAttribute("value_moTa") + "";
	
	if(value_maSanPham.equals("null")){
		value_maSanPham = "";
	}
	if(value_tenSanPham.equals("null")){
		value_tenSanPham = "";
	}
	if(value_giaBan.equals("null")){
		value_giaBan = "";
	}
	if(value_giaNhap.equals("null")){
		value_giaNhap = "";
	}
	if(value_hanSuDung.equals("null")){
		value_hanSuDung = "";
	}
	if(value_vat.equals("null")){
		value_vat = "";
	}
	if(value_moTa.equals("null")){
		value_moTa = "";
	}
%>
	<div class ="container mt-4">
			<form action="SaveProduct" class="row g-3 needs-validation" id="myForm" novalidate>
			<div class="row">
		  		<div class="col-6">
				    <label for="maSanPham" class="form-label">Mã sản phẩm<span class ="rq">*</span></label>
				    <input type="text" class="form-control" id="maSanPham" name="maSanPham" value ="<%= value_maSanPham %>" required>
				    <div class="error" id="error_maSanPham"><%= e_maSanPham %></div>
			  	</div>
			  	<div class="col-6">
			  		<label for="tenSanPham" class="form-label">Tên sản phẩm<span class ="rq">*</span></label>
			    	<input type="text" class="form-control" id="tenSanPham" name="tenSanPham" value ="<%= value_tenSanPham %>"  required>
			    	<div class="error" id="error_tenSanPham"><%= e_tenSanPham %></div>
			  	</div>
		  	</div>
		  <div class="row">
		  		<div class="col-6">
				    <label for="giaNhap" class="form-label">Giá nhập<span class ="rq">*</span></label>
				    <input type="number" class="form-control" id="giaNhap" name="giaNhap" value ="<%= value_giaNhap %>"  required>
				    <div class="error" id="error_giaNhap"><%= e_giaNhap %></div>
			    </div>
			    <div class="col-6">
			    	 <label for="giaBan" class="form-label">Giá bán<span class ="rq">*</span></label>
			   		 <input type="number" class="form-control" id="giaBan" name="giaBan" value ="<%= value_giaBan %>" required>
			   		 <div class="error" id="error_giaBan"><%= e_giaBan %></div>
			    </div>
		  </div>
		  <div class="row">
		  		<div class="col-6">
				    <label for="hanSuDung" class="form-label">Hạn sử dụng</label>
				    <input type="datetime-local" class="form-control" id="hanSuDung" name="hanSuDung" value ="<%= value_hanSuDung %>"  required>
				    <div class="error" id="error_hanSuDung"></div>
			    </div>
			    <div class="col-6">
			    	 <label for="vat" class="form-label">VAT</label>
			   		 <input type="number" class="form-control" id="vat" name="vat" value ="<%= value_vat %>" required>
			   		 <div class="error" id="error_vat"></div>
			    </div>
		  </div>
		   <div class="row">
		    	<label for="moTa" class ="form-label">Mô tả sản phẩm</label>
		    	<textarea rows="10" cols="20" class="form-control" name="moTa" value = <%= value_moTa %>></textarea>
		   </div>
		   <div class="row">
			    <button class="btn btn-primary" type="button" onclick="mySubmit()">Lưu sản phẩm</button>
		  </div>
		</form>
	</div>
	<script type="text/javascript">
		function mySubmit(){
			// Bắt lỗi
			let isValid = true;
			let maSanPham = document.getElementById("maSanPham");
			let tenSanPham = document.getElementById("tenSanPham");
			let giaNhap = document.getElementById("giaNhap");
			let giaBan = document.getElementById("giaBan");
			
			if(maSanPham.value.trim() === ""){
				let error = document.getElementById("error_maSanPham");
				error.innerHTML = "Mã sản phẩm không hợp lệ!";
				isValid = false;
			}
			
			
			
			if(tenSanPham.value.trim() === ""){
				let error = document.getElementById("error_tenSanPham");
				error.innerHTML = "Tên sản phẩm không hợp lệ!";
				isValid = false;
			}
			
			if(giaBan.value.trim() === ""){
				let error = document.getElementById("error_giaBan");
				error.innerHTML = "Giá bán không hợp lệ!";
				isValid = false;
			}
			
			if(giaNhap.value.trim() === ""){
				let error = document.getElementById("error_giaNhap");
				error.innerHTML = "Giá nhập không hợp lệ!";
				isValid = false;
			}
			
	
			
			if(isValid){
				var myForm = document.getElementById("myForm");
				myForm.submit();
				alert("Lưu sản phẩm thành công!");
			}
			
		}
	</script>
</body>
</html>