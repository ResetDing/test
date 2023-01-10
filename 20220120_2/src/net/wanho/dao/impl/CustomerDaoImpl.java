package net.wanho.dao.impl;

import java.util.List;

import net.wanho.dao.CustomerDao;
import net.wanho.entity.Customer;
import net.wanho.util.JDBCTemplate;

public class CustomerDaoImpl implements CustomerDao {
	
	private final JDBCTemplate jdbcTemplate = new JDBCTemplate();
	private static final String INSERT_DQL = 
			"insert into customer (name, account, password, balance) value (?, ?, ?, ?)";

	@Override
	public int insert(Customer customer) {
		return jdbcTemplate.update(INSERT_DQL, customer.getName(), 
				customer.getAccount(), customer.getPassword(), customer.getBalance());
	}

	@Override
	public int update(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> queryForList(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
