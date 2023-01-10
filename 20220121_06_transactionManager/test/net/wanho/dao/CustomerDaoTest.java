package net.wanho.dao;

import org.junit.Test;

import junit.framework.Assert;
import net.wanho.dao.impl.CustomerDaoImpl;
import net.wanho.entiy.Customer;

public class CustomerDaoTest {
	
	private CustomerDao dao = new CustomerDaoImpl();
	

	@Test
	public void testUpdate() {
		Customer c = dao.findByAccount("zhangsan");
		c.setBalance(c.getBalance() - 10);
		dao.update(c);
	}

	@Test
	public void testFindByAccount() {
		Customer c = dao.findByAccount("zhangsan");
		Assert.assertNotNull(c);
	}

}
