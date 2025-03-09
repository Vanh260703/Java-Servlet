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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy thông tin
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean error = false;

		if (userName == null || userName.trim().length() == 0) {
			request.setAttribute("e_userName", "Không được để trống tên đăng nhập!");
			error = true;
		}

		if (password == null || password.trim().length() == 0) {
			request.setAttribute("e_password", "Không được để trống password");
			error = true;
		}
		String url = "";
		if (error) {
			// error = true
			// Kiểm tra thông tin tài khoản và mật khẩu
			if (userName.equalsIgnoreCase("vanh") && password.equals("123")) {
				request.setAttribute("e_login", "Sai tên đăng nhập hoặc mật khẩu!");
				url = "/login.jsp";
			}
		} else {
			url = "/trangchu.jsp";
			// set session
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);

		}

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
