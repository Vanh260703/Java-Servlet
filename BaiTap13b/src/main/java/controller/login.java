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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String url = "";
		boolean checkError = false;

		if (userName == null || userName.trim().length() == 0) {
			request.setAttribute("e_userName", "Không được để trống tên đăng nhập!");
			checkError = true;
		} else if (!userName.equalsIgnoreCase("vanh")) {
			request.setAttribute("e_userName", "Sai tên đăng nhập hoặc mật khẩu!");
			checkError = true;
		}

		if (password == null || password.trim().length() == 0) {
			request.setAttribute("e_password", "Không được để trống mật khẩu!");
			checkError = true;
		} else if (!password.equalsIgnoreCase("123")) {
			request.setAttribute("e_password", "Sai tên đăng nhập hoặc mật khẩu!");
			checkError = true;
		}

		if (checkError) {
			url = "/login.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			url = "/success.jsp";

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
