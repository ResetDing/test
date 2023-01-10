package net.wanho.service;

import org.junit.Test;

import net.wanho.service.impl.CustomerServiceImpl;

public class CustomerServiceTest {
	
	private CustomerService customerService = new CustomerServiceImpl();

	@Test
	public void testTransfer() {
		customerService.transfer("zhangsan", "lisi", 100.0D);
	}

}
