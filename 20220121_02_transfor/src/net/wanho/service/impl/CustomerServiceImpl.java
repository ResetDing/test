package net.wanho.service.impl;

import net.wanho.dao.CustomerDao;
import net.wanho.dao.impl.CustomerDaoImpl;
import net.wanho.entiy.Customer;
import net.wanho.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public boolean transfer(String fromAccount, String toAccount, Double money) {
		// 转出账号扣钱
		Customer fromCustomer = customerDao.findByAccount(fromAccount);
		fromCustomer.setBalance(fromCustomer.getBalance() - money);
		int fromRows = customerDao.update(fromCustomer);
		if (fromRows == 0) {
			return false;
		}
		
		// 转入账号加钱
		Customer toCustomer = customerDao.findByAccount(toAccount);
		toCustomer.setBalance(toCustomer.getBalance() + money);
		int toRows = customerDao.update(toCustomer);
		if (toRows == 0) {
			return false;
		}
		
		return true;
	}

}
