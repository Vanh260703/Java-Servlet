package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class muaHang
 */
@WebServlet("/muaHang")
public class muaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public muaHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set character
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String soLuong = request.getParameter("soLuong");
		String soDienThoai = request.getParameter("soDienThoai");
		String email = request.getParameter("email");

		boolean checkError = false;
		double giaTri_soLuong = 0;

		System.out.println("giá trị nhập vào" + soLuong);

		try {
			giaTri_soLuong = Double.parseDouble(soLuong);
		} catch (Exception e) {
			// TODO: handle exception
			checkError = true;
			request.setAttribute("e_soLuong", "Nhập dữ liệu số lượng không đúng!");
		}
		if (giaTri_soLuong == 0) {
			checkError = true;
			request.setAttribute("e_soLuong", "Vui lòng chọn số lượng mua lớn hơn 0!");
		}

		// Kiểm tra số điện thoại

		Pattern soDienThoaiPattern = Pattern.compile("\\d{10}");
		Matcher soDienThoaiMatcher = soDienThoaiPattern.matcher(soDienThoai);
		if (!soDienThoaiMatcher.matches()) {
			checkError = true;
			request.setAttribute("e_soDienThoai", "Số điện thoại phải bao gồm 10 ký tự!");
		}

		// Kiểm tra email
		Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+");
		Matcher emailMatcher = emailPattern.matcher(email);

		if (!emailMatcher.matches()) {
			checkError = true;
			request.setAttribute("e_email", "Cấu trúc email chưa đúng!");
		}
		String url = "/success.jsp";
		if (checkError) {
			url = "/index.jsp";
		}

		request.setAttribute("value_soLuong", soLuong);
		request.setAttribute("value_soDienThoai", soDienThoai);
		request.setAttribute("value_email", email);

		// forward
		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
