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
		String [] cpu = request.getParameterValues("cpu");
		String [] gpu = request.getParameterValues("gpu");
		String [] main = request.getParameterValues("main");
		String ram = request.getParameter("ram");
		String [] accessories = request.getParameterValues("accessories");
		double cpuPrice = 0;
		double gpuPrice = 0;
		double mainPrice = 0;
		double ramPrice = 0;
		double accessoriesPrice = 0;
		double totalAmount = 0;
		if(cpu != null){
			for(String option: cpu){
				if(option.equals("coreI5")){
					cpuPrice = 2000000;
				}else if(option.equals("coreI7")){
					cpuPrice = 3000000;
				}else if(option.equals("coreI9")){
					cpuPrice = 5000000;
				}
			}
			totalAmount += cpuPrice;
		}
		
		if(gpu != null){
			for(String option: gpu){
				if(option.equals("2060S")){
					gpuPrice = 4000000;
				}else if(option.equals("3060")){
					gpuPrice = 7000000;
				}else if(option.equals("4060")){
					gpuPrice = 10000000;
				}
			}
			totalAmount += gpuPrice;
		}
		
		if(main != null){
			for(String option: main){
				if(option.equals("B660M")){
					mainPrice = 3000000;
				}else if(option.equals("B760M")){
					mainPrice = 5000000;
				}else if(option.equals("Z690M")){
					mainPrice = 8000000;
				}
			}
			totalAmount += mainPrice;
		}
		
		if(ram != null){
			if(ram.equals("ram8GB")){
				ramPrice = 600000;
			}else if(ram.equals("ram16GB")){
				ramPrice = 1200000;			
				}
			totalAmount += ramPrice;
		}
	
		if(accessories != null){
			for(String item : accessories){
				switch(item){
					case "printer":
						accessoriesPrice += 5000000;
						break;
					case "scanner":
						accessoriesPrice += 4000000;
						break;
					case "camera":
						accessoriesPrice += 2000000;
						break;
				}
			}
			totalAmount += accessoriesPrice;
		}
	%>
	<form action="confirm.jsp">
		<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Sản Phẩm</th>
	      <th scope="col">Giá tiền</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	    if(cpu != null){
			for(String option : cpu){
				if(option.equals("coreI5")){
					cpuPrice = 2000000;
				}else if(option.equals("coreI7")){
					cpuPrice = 3000000;
				}else if(option.equals("coreI9")){
					cpuPrice = 5000000;
				}
	    %>
	    <tr>
	      <td><%= option %></td>
	      <td><%= cpuPrice %></td>
	    </tr>
	    <% 
	    }
			}%>
			
		<%
	    if(gpu != null){
			for(String option : gpu){
				if(option.equals("2060S")){
					gpuPrice = 4000000;
				}else if(option.equals("3060")){
					gpuPrice = 7000000;
				}else if(option.equals("4060")){
					gpuPrice = 10000000;
				}
	    %>
	    <tr>
	      <td><%= option %></td>
	      <td><%= gpuPrice %></td>
	    </tr>
	    <% 
	    }
			}%>	
		<%
	    if(main != null){
			for(String option : main){
				if(option.equals("B660M")){
					mainPrice = 3000000;
				}else if(option.equals("B760M")){
					mainPrice = 5000000;
				}else if(option.equals("Z690M")){
					mainPrice = 8000000;
				}
	    %>
	    <tr>
	      <td><%= option %></td>
	      <td><%= mainPrice %></td>
	    </tr>
	    <% 
	    }
			}%>
		<tr>
			<td><%= ram %></td>
			<td><%= ramPrice %></td>
		</tr>
		<%
	    if(accessories != null){
			for(String item : accessories){
				switch(item){
				case "printer":
					accessoriesPrice = 5000000;
					break;
				case "scanner":
					accessoriesPrice = 4000000;
					break;
				case "camera":
					accessoriesPrice = 2000000;
					break;
			}
	    %>
	    <tr>
	      <td><%= item %></td>
	      <td><%= accessoriesPrice %></td>
	    </tr>
	    <% 
	    }
			}%>
		<tr>
			<td>Tổng</td>
			<td><%= totalAmount %></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button class = "btn btn-primary" type = "submit">Xác nhận thanh toán</button>
			</td>
		</tr>
	  </tbody>
	</table>
	</form>
</body>
</html>