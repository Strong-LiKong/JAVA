package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountServiceImpl;

/**
 * Servlet implementation class ChangePasswordSerlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountServiceImpl accountserviceimpl = new AccountServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String originalpassword = request.getParameter("originalPassword");
		String newpassword = request.getParameter("newPassword");

		// 获取登录时产生的登陆索引
		int accountIndex = (Integer) request.getSession().getAttribute("accountindex");

		String result = accountserviceimpl.changePassword(accountIndex, originalpassword, newpassword);

		if (result.equals(originalpassword)) {
//			request.setAttribute("massage1", "密码修改成功！！！");
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		}else{
			request.setAttribute("massage2", "原始密码输入错误！！");
			request.getRequestDispatcher("changePassword.jsp").forward(request, response);
		}

		
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
