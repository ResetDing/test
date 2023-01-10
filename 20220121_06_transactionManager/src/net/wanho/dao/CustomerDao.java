package net.wanho.dao;

import net.wanho.entiy.Customer;

public interface CustomerDao {
	
	/**
	 * 修改
	 * @param customer
	 * @return
	 */
	public int update(Customer customer);
	
	public Customer findByAccount(String account);

}
