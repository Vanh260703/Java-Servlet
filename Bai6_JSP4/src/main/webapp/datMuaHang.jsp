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
	<h1>Chào mừng bạn đã đến vào trang đặt hàng! Vui lòng chọn sản phẩm mà bạn muốn mua!</h1>
	<form action="baoGia.jsp" method="POST">
	<!-- CPU -->
	<h2>CPU</h2>
	<select class="form-select" aria-label="Default select example" name ="cpu">
  		<option selected >Open this select CPU menu</option>
  		<option value="coreI5">Core I5</option>
  		<option value="coreI7">Core I7</option>
  		<option value="coreI9">Core I9</option>
	</select>	
	<!-- END CPU -->
	<h2>GPU</h2>
	<!-- GPU -->
	<select class="form-select" aria-label="Default select example" name = "gpu">
  		<option selected >Open this select GPU menu</option>
  		<option value="2060S">2060S</option>
  		<option value="3060">3060</option>
  		<option value="4060">4060</option>
	</select>	
	<!-- END GPU -->	
	<!-- MAIN -->
	<h2>MAIN</h2>
	<select class="form-select" aria-label="Default select example" name = "main">
  		<option selected >Open this select MAIN menu</option>
  		<option value="B660M">B660M</option>
  		<option value="B760M">B760M</option>
  		<option value="Z690M">Z690M</option>
	</select>
	<!-- END MAIN -->
	<!-- RAM -->
	<h2>RAM</h2>
	<div class="form-check">
  		<input class="form-check-input" type="radio" name="ram" id="ram8GB" value ="ram8GB">
  		<label class="form-check-label" for="ram8GB">
    		RAM 8GB
  		</label>
	</div>
	<div class="form-check">
	  		<input class="form-check-input" type="radio" name="ram" id="ram16GB" value="ram16GB">
	  		<label class="form-check-label" for="ram16GB">
	    		RAM 16GB
	  		</label>
	</div>
	<!-- END RAM -->
	<!-- ACCESSORIES -->
		<h2>ACCESSORIES</h2>
			<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="printer" id="printer" name = "accessories">
		  <label class="form-check-label" for="printer">
		    Printer
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="scanner" id="scanner" name = "accessories">
		  <label class="form-check-label" for="scanner">
		    Scanner
		  </label>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="camera" id="camera" name = "accessories">
		  <label class="form-check-label" for="camera">
		    Camera
		  </label>
		</div>
	<!-- END ACCESSORIES -->
	<button class ="btn btn-primary">Đặt hàng</button>
	
	</form>
</body>
</html>