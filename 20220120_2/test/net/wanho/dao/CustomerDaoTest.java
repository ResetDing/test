package net.wanho.dao;

import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

import net.wanho.dao.impl.CustomerDaoImpl;
import net.wanho.entity.Customer;

public class CustomerDaoTest {
	
	private CustomerDao CustomerDao = new CustomerDaoImpl();

	@Test
	public void testInsert() {
		Customer customer = new Customer("ÕÅÈý", "zhangsan", "123456", new BigDecimal(100));
		CustomerDao.insert(customer);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryForList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

}
