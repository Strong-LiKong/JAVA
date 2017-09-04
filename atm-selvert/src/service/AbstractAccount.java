package service;

import model.Account;

public abstract class AbstractAccount implements AccountService {
	public static Account[] accounts = new Account[2];

	/**
	 * 初始化账户信息
	 */
	@Override
	public void initAccounts() {
		// 实例化第一个账户
		Account account1 = new Account();
		account1.setName("hello");
		account1.setPassword("123");
		account1.setBalance(309.5);
		accounts[0] = account1;

		// 实例化第二个账户
		Account account2 = new Account();
		account2.setName("abc");
		account2.setPassword("abc");
		account2.setBalance(983.6);
		accounts[1] = account2;
	}

	/**
	 * 账户登录
	 */
	@Override
	public int login(String inputName, String inputPassword) {

		// 对二维数组里的数据进行匹配
		for (int j = 0; j < accounts.length; j++) {
			// 正确匹配用户名和密码
			if (accounts[j].getName().equals(inputName) && accounts[j].getPassword().equals(inputPassword)) {
				// // 返回索引值
				return j;
			}

		}
		return -1;
	}

	public String changePassword(int accountIndex, String originalPassword, String newPassword,
			String newPasswordAgain) {
		// TODO Auto-generated method stub
		return null;
	}

}
