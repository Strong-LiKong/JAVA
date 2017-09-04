package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountServiceImpl;

/**
 * Servlet implementation class WithdrawSelvert
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountServiceImpl accountserviceimpl = new AccountServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WithdrawServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取输入的取款金额
		double withdrawAccount = Double.valueOf(request.getParameter("withdrawAmount"));
		// 获取登录时产生的登陆索引
		int accountIndex = (Integer) request.getSession().getAttribute("accountindex");
		// 执行取款方法，并且接收返回的新余额
		double withdrawBalance = accountserviceimpl.withdraw(accountIndex, withdrawAccount);
		// 判断余额是否充足

		if (withdrawBalance != -1) {
			request.setAttribute("withdrawBalance", "余额为：" + withdrawBalance);
			request.setAttribute("withdrawAmount", "取款金额为：" + withdrawAccount);
			request.getRequestDispatcher("withdraw.jsp").forward(request, response);
		} else {
			request.setAttribute("massage", "余额不足，请重新输入");
			request.getRequestDispatcher("withdraw.jsp").forward(request, response);
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
