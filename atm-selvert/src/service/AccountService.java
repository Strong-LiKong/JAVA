package service;

public interface AccountService {
	// 账户信息初始化方法
	void initAccounts();

	// 登录
	int login(String inputName, String inputPassword);

	// 查询
	double queryBalance(int accountIndex);

	// 存款
	double deposit(int accountIndex, double depositAccount);

	// 取款
	double withdraw(int accountIndex, double withdrawAccount);

	// 转账
	double transfer(int accountIndex, double transferAccount, String othername);

	// 修改密码
	String changePassword(int accountIndex, String originalPassword, String newPassword);

}
