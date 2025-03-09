package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveProduct
 */
@WebServlet("/SaveProduct")
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveProduct() {
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
		// Set UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String maSanPham = request.getParameter("maSanPham");
		String tenSanPham = request.getParameter("tenSanPham");
		String giaBan_String = request.getParameter("giaBan");
		String giaNhap_String = request.getParameter("giaNhap");
		String hanSuDung_String = request.getParameter("hanSuDung");
		String vat_String = request.getParameter("vat");
		String moTa = request.getParameter("moTa");

		// CHECK

		String e_maSanPham = "";
		String e_tenSanPham = "";
		String e_giaNhap = "";
		String e_giaBan = "";
		if (maSanPham == null || maSanPham.trim().length() == 0) {
			e_maSanPham = "Vui lòng nhập mã sản phẩm";
		} else if (maSanPham.equals("123")) {
			e_maSanPham += "Mã sản phẩm 123 đã tồn tại, vui lòng nhập lại mã sản phẩm!";
		}

		if (tenSanPham == null || tenSanPham.trim().length() == 0) {
			e_tenSanPham = "Không được để trống tên sản phẩm";
		} else if (tenSanPham.equalsIgnoreCase("Iphone 15")) {
			e_tenSanPham = "Sản phẩm Iphone 15 đã tồn tại, vui lòng nhập tên sản phẩm khác!";
		}

		if (giaNhap_String == null || giaNhap_String.trim().length() == 0) {
			e_giaNhap = "Không được để trống giá nhập";
		} else if (Integer.valueOf(giaNhap_String) < 0) {
			e_giaNhap = "Giá nhập không được âm!";
		}

		if (giaBan_String == null || giaBan_String.trim().length() == 0) {
			e_giaBan = "Không được để trống giá bán";
		} else if (Integer.valueOf(giaBan_String) < 0) {
			e_giaBan = "Giá bán không được âm!";
		} else if (Integer.valueOf(giaBan_String) < Integer.valueOf(giaNhap_String) * 2) {
			e_giaBan = "Giá bán không được nhỏ hơn 2 lần giá nhập!";
		}

		// forward error
		request.setAttribute("e_maSanPham", e_maSanPham);
		request.setAttribute("e_tenSanPham", e_tenSanPham);
		request.setAttribute("e_giaNhap", e_giaNhap);
		request.setAttribute("e_giaBan", e_giaBan);

		// forward value
		request.setAttribute("value_maSanPham", maSanPham);
		request.setAttribute("value_tenSanPham", tenSanPham);
		request.setAttribute("value_giaBan", giaBan_String);
		request.setAttribute("value_giaNhap", giaNhap_String);
		request.setAttribute("value_hanSuDung", hanSuDung_String);
		request.setAttribute("value_vat", vat_String);
		request.setAttribute("value_moTa", moTa);
		// url
		String url = "/success.jsp";
		if (e_maSanPham.length() > 0) {
			url = "/product.jsp";
		}
		if (e_tenSanPham.length() > 0) {
			url = "/product.jsp";
		}
		if (e_giaNhap.length() > 0) {
			url = "/product.jsp";
		}
		if (e_giaBan.length() > 0) {
			url = "/product.jsp";
		}

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
