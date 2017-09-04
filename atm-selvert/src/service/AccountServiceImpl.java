package service;

public class AccountServiceImpl extends AbstractAccount {
	/**
	 * 余额查询
	 */
	@Override
	public double queryBalance(int accountIndex) {
		// 定义一个变量接收登陆的用户的余额
		double querybalance = accounts[accountIndex].getBalance();
		// 将登陆的用户的余额返回
		return querybalance;
	}

	/**
	 * 存款
	 */
	@Override
	public double deposit(int accountIndex, double depositAccount) {
		// 定义一个变量接收登陆的用户的余额
		double querybalance = accounts[accountIndex].getBalance();
		// 将余额和存款数目相加，得到心得余额
		double depositbalance = querybalance + depositAccount;
		// 将新的余额赋值给登陆的用户
		accounts[accountIndex].setBalance(depositbalance);
		// 将新余额返回
		return depositbalance;
	}

	/**
	 * 取款
	 */
	@Override
	public double withdraw(int accountIndex, double withdrawAccount) {
		// 定义一个变量接收登陆的用户的余额
		double querybalance = accounts[accountIndex].getBalance();
		// 将余额和存款数目相减，得到新的余额
		double withdrawbalance = querybalance - withdrawAccount;
		// 判断余额是否充足
		if (withdrawbalance >= 0) {
			// 将新的余额赋值给登陆的用户
			accounts[accountIndex].setBalance(withdrawbalance);
			return withdrawbalance;
		} else {
			return -1;
		}

	}

	/**
	 * 转账
	 */
	@Override
	public double transfer(int accountIndex, double transferAccount, String othername) {
		double newbalance;
		// 定义一个变量接收登陆的用户的余额
		double balance = accounts[accountIndex].getBalance();
		// 判断输入的用户是否存在
		for (int i = 0; i < accounts.length; i++) {
			// 判断输入的用户是否存在
			if (accounts[i].getName().equals(othername)) {
				// 判断输入用户是否为自己
				if (accounts[accountIndex].getName().equals(othername)) {
					return 0;
				} else {
					newbalance = balance - transferAccount;
					// 判断余额是否充足
					if (newbalance >= 0) {
						accounts[accountIndex].setBalance(newbalance);
						accounts[i].setBalance(transferAccount + accounts[i].getBalance());
						return newbalance;
					} else {
						return -1;
					}
				}

			} else {
				continue;
			}

		}

		return -2;

	}

	/**
	 * 修改密码
	 */
	@Override
	public String changePassword(int accountIndex, String originalPassword, String newPassword) {
		if (accounts[accountIndex].getPassword().equals(originalPassword)) {

			accounts[accountIndex].setPassword(newPassword);
			return originalPassword;
		} else {
			return newPassword;
		}
	}

}
