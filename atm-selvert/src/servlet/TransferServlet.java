package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountServiceImpl;

/**
 * Servlet implementation class TransferSelvert
 */
@WebServlet("/TransferSelvert")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountServiceImpl accountserviceimpl = new AccountServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransferServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取输入的转账的对方的账户
		String targetAccountName = request.getParameter("targetAccountName");
		// 获取输入的转账金额
		double transferAmount = Double.valueOf(request.getParameter("transferAmount"));

		// 获取登录时产生的登陆索引
		int accountIndex = (Integer) request.getSession().getAttribute("accountindex");
		
		double transfer=accountserviceimpl.transfer(accountIndex, transferAmount, targetAccountName);
		
		if(transfer==0){
			request.setAttribute("massage", "不能给自己转账！！！");
			request.getRequestDispatcher("transfer.jsp").forward(request, response);
		}else if(transfer==-1){
			request.setAttribute("massage", "账户余额不足，转账失败！！！");
			request.getRequestDispatcher("transfer.jsp").forward(request, response);
		}else if(transfer==-2){
			request.setAttribute("massage", "账户不存在！！！");
			request.getRequestDispatcher("transfer.jsp").forward(request, response);
		}else{
			request.setAttribute("massage1", "转账金额为："+transferAmount);
			request.setAttribute("massage2", "余额为："+transfer);
			request.getRequestDispatcher("transfer.jsp").forward(request, response);
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
