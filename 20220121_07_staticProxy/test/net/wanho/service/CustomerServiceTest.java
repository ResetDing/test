package net.wanho.service;

import org.junit.Test;

import net.wanho.service.impl.CustomerServiceImpl;
import net.wanho.service.impl.CustomerServiceImplProxy;

public class CustomerServiceTest {
	
	private CustomerService proxy = new CustomerServiceImplProxy();

	@Test
	public void testTransfer() {
		proxy.transfer("zhangsan", "lisi", 100.0D);
	}

}
