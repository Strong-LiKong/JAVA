package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountServiceImpl;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AccountServiceImpl accountserviceimpl = new AccountServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepositServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取输入的存款金额
		double depositAccount = Double.valueOf(request.getParameter("depositAmount"));
		// 获取登录时产生的登陆索引
		int accountIndex = (Integer) request.getSession().getAttribute("accountindex");
		// 执行存款方法，并且接收返回的新余额
		double depositBalance = accountserviceimpl.deposit(accountIndex, depositAccount);

		// 将存款金额和存款后的新余额传递下去
		request.setAttribute("depositAccount", "存款金额为："+depositAccount);
		request.setAttribute("depositBalance", "余额为："+depositBalance);

		request.getRequestDispatcher("deposit.jsp").forward(request, response);

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
