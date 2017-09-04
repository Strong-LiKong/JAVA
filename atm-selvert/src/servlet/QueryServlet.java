package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountServiceImpl;

/**
 * Servlet implementation class QuerySelvert
 */
@WebServlet(urlPatterns = "/QueryServlet", loadOnStartup = 2)
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AccountServiceImpl accountserviceimpl = new AccountServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取登陆时产生的索引
		int accountindex = (Integer) request.getSession().getAttribute("accountindex");
		// 执行余额查询方法，并且返回余额
		double balance = accountserviceimpl.queryBalance(accountindex);
		// 把余额传递到界面
		request.setAttribute("balance", balance);

		request.getRequestDispatcher("query.jsp").forward(request, response);

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
