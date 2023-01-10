package net.wanho.service;

public interface CustomerService {
	
	/**
	 * 转账
	 * @param fromAccount 	转出账号
	 * @param toAccount		转入账号
	 * @param money			转账金额
	 * @return true 转账成功， false 转账失败
	 */
	public boolean transfer(String fromAccount, String toAccount, Double money);

}
