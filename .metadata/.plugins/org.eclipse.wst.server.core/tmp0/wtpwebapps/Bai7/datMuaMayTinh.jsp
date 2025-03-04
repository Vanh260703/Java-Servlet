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
	<%
		// Radio button => name
		String processor = request.getParameter("processor");
		String ram = request.getParameter("ram");
		double processorPrice = 0;
		double ramPrice = 0;
		double monitorPrice = 0;
		double accessoriesPrice = 0;
		double totalAmount = 0;
		if(processor != null){
			if(processor.equals("CoreI9")){
				processorPrice = 5000000;
			}else if(processor.equals("CoreI7")){
				processorPrice = 4000000;
			}else if(processor.equals("CoreI5")){
				processorPrice = 3000000;
			}
			totalAmount += processorPrice;
		}
		
		if(ram != null){
			if(ram.equals("8GB")){
				ramPrice = 500000;
			}else if(ram.equals("16GB")){
				ramPrice = 1200000;
			}
		totalAmount += ramPrice;
		}
		
		//Checkbox => name
		String monitor = request.getParameter("monitor");
		if(monitor != null){
			monitorPrice += 1500000;
		}
		//Select String [] mang =  getParameterValues("ten");
		
		String[] accessories = request.getParameterValues("accessories");
		if(accessories != null){
		for(String option: accessories){
			if(option.equals("Camera")){
				accessoriesPrice = 800000;
			}else if(option.equals("Printer")){
				accessoriesPrice = 1500000;
			}else if(option.equals("Scanner")){
				accessoriesPrice = 1500000;
			}
		}
			totalAmount += accessoriesPrice;
		}
	%>
	
	<h1>HOÁ ĐƠN</h1>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Tên sản phẩm</th>
	      <th scope="col">Giá tiền</th>
	    </tr>
	  </thead>
	  <tbody>
	  <% if(processor != null){ %>
	    <tr>
	      <td><%= processor %></td>
	      <td><%= processorPrice %></td>
	    </tr>
	    <% } %>
	    <% if(ram != null){ %>
	    <tr>
	      <td><%= ram %></td>
	      <td><%= ramPrice %></td>
	    </tr>
	    <% } %>
	    <% if(monitor != null){ %>
	    <tr>
	      <td><%= monitor %></td>
	      <td><%= monitorPrice %></td>
	    </tr>
	    <% } %>
	    <%
	    	if(accessories != null){
			for(String option: accessories){
				if(option.equals("Camera")){
					accessoriesPrice = 800000;
				}else if(option.equals("Printer")){
					accessoriesPrice = 1500000;
				}else if(option.equals("Scanner")){
					accessoriesPrice = 1500000;
				}
				%>
				<tr>
					<td><%= option %></td> 
					<td><%= accessoriesPrice %></td>
				</tr>
				<%
			}
	    	}
			%>
			<tr>
				<td>Tổng:</td>
				<td><%= totalAmount %></td>
			</tr>
	  </tbody>
</table>
</body>
</html>