package net.wanho.service.impl;

import net.wanho.service.CustomerService;
import net.wanho.trans.TransactionManager;
import net.wanho.trans.TransactionManagerImpl;

public class CustomerServiceImplProxy implements CustomerService {
	
	private CustomerService target = new CustomerServiceImpl();
	private TransactionManager transactionManager = new TransactionManagerImpl();

	@Override
	public boolean transfer(String fromAccount, String toAccount, Double money) {
		boolean result = false;
		try {
			transactionManager.start();
			result = target.transfer(fromAccount, toAccount, money);
			transactionManager.commit();
		} catch (Exception e ) {
			e.printStackTrace();
			transactionManager.rollback();
		}
		return result;
	}

}
