package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addProduct
 */
@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product = request.getParameter("product");
		String quantity = request.getParameter("quantity");
		String importPrice = request.getParameter("import_price");
		String sellingPrice = request.getParameter("selling_price");
		String describe = request.getParameter("describe");

		boolean error = false;

		if (product == null || product.trim().length() == 0) {
			request.setAttribute("e_product", "Không được để trống tên sản phẩm");
			error = true;
		}

		if (quantity == null || quantity.trim().length() == 0) {
			request.setAttribute("e_quantity", "Không được để trống số lượng sản phẩm");
			error = true;
		}

		if (importPrice == null || importPrice.trim().length() == 0) {
			request.setAttribute("e_importPrice", "Không được để trống giá nhập");
			error = true;
		}

		if (sellingPrice == null || sellingPrice.trim().length() == 0) {
			request.setAttribute("e_sellingPrice", "Không được để trống giá bán");
			error = true;
		}
		String url = "";

		if (product.equalsIgnoreCase("cam") || product.equalsIgnoreCase("táo")) {
			error = false;
		} else {
			error = true;
			request.setAttribute("e_product", "Sản phẩm bạn thêm không hợp lệ!");
		}

		int IntQuantity = 0;
		double DoubleImportPrice = 0;
		double DoubleSellingPrice = 0;

		try {
			IntQuantity = Integer.parseInt(quantity);
			if (IntQuantity < 0) {
				request.setAttribute("e_quantity", "Số lượng không được âm");
				error = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("e_quantity", "Bạn không nhập đúng định dạng!");
			error = true;
		}

		try {
			DoubleImportPrice = Double.parseDouble(importPrice);
			if (DoubleImportPrice < 0) {
				request.setAttribute("e_importPrice", "Giá không được âm");
				error = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("e_quantity", "Bạn không nhập đúng định dạng!");
			error = true;
		}

		try {
			DoubleSellingPrice = Double.parseDouble(sellingPrice);
			if (DoubleSellingPrice < 0) {
				request.setAttribute("e_sellingPrice", "Giá không được âm");
				error = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("e_sellingPrice", "Bạn không nhập đúng định dạng!");
			error = true;
		}

		if (DoubleSellingPrice < DoubleImportPrice * 2) {
			error = true;
			request.setAttribute("e_sellingPrice", "Giá bán không được nhỏ hơn 2 lần giá nhập!");
		}

		if (error) {
			url = "/themsanpham.jsp";
		} else {
			url = "/success.jsp";
			HttpSession session = request.getSession(false);

			if (session != null) {
				session.setAttribute("product", product);
				session.setAttribute("quantity", quantity);
				session.setAttribute("importPrice", importPrice);
				session.setAttribute("sellingPrice", sellingPrice);
				session.setAttribute("describe", describe);
			}
		}

		request.setAttribute("value_product", product);
		request.setAttribute("value_quantity", quantity);
		request.setAttribute("value_importPrice", importPrice);
		request.setAttribute("value_sellingPrice", sellingPrice);

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
