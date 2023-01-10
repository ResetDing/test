package net.wanho.dao;

import java.util.List;

import net.wanho.entity.Customer;

public interface CustomerDao {
	
	public int insert(Customer customer);
	
	
	public int update(Customer customer);
	
	
	public int delete(Integer id);
	
	public List<Customer> queryForList(Customer customer);
	
	public Customer getById(Integer id);

}
