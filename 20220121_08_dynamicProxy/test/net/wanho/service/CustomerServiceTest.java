package net.wanho.service;

import org.junit.Test;

import net.wanho.proxy.TransactionProxy;
import net.wanho.service.impl.CustomerServiceImpl;

public class CustomerServiceTest {
	
	

	@Test
	public void testTransfer() {
		CustomerService customerService = new CustomerServiceImpl();
		CustomerService proxy = (CustomerService) TransactionProxy.createProxy(customerService);
		proxy.transfer("zhangsan", "lisi", 100.0D);
	}

}
