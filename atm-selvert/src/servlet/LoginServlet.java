package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AccountServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/LoginServlet", loadOnStartup = 2)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AccountServiceImpl accountserviceimpl = new AccountServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

		accountserviceimpl.initAccounts();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取输入的用户名和密码
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		// 执行登陆方法，并且将登陆时产生的索引号保留
		int accountIndex = accountserviceimpl.login(name, password);

		// 判断用户登陆信息是否匹配
		if (accountIndex != -1) {
			// 将产生的索引用session保存起来
			session.setAttribute("accountindex", accountIndex);

			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("massage", "用户名和密码错误！！！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
