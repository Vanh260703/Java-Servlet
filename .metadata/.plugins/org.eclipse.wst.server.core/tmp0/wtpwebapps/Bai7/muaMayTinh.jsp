<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
<div class = "container">
	<h1>Chọn cấu hình máy tính bạn cần mua</h1>
	<hr/>
	<form action="datMuaMayTinh.jsp" method = "POST">
	<h2>Processor</h2>
		<div class="form-check">
  <input class="form-check-input" type="radio" name="processor" id = "CoreI9" value = "CoreI9">
  <label class="" for="CoreI9">
    CoreI9
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="processor" id="CoreI7" value = "CoreI7" >
  <label class="form-check-label" for="CoreI7">
    CoreI7
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="processor" id="CoreI5" value = "CoreI5" >
  <label class="form-check-label" for="CoreI5">
    CoreI5
  </label>
</div>
<h2>RAM</h2>
<div class="form-check">
  <input class="form-check-input" type="radio" name="ram" id="8GB" value = "8GB" >
  <label class="form-check-label" for="8GB">
    8GB
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="ram" id="16GB" value = "16GB" >
  <label class="form-check-label" for="16GB">
    16GB
  </label>
</div>
<h2>Monitor</h2>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="Monitor" id="monitor" name = "monitor">
  <label class="form-check-label" for="monitor">
    Monitor
  </label>
</div>
<h2>Accessories</h2>
<select class="form-select" multiple aria-label="multiple select example" name = "accessories">
  <option value="Camera">Camera</option>
  <option value="Printer">Printer</option>
  <option value="Scanner">Scanner</option>
</select>
<button class = "btn btn-primary" type = "submit">Buy</button>
	</form>
	</div>
</body>
</html>