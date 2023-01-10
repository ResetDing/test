package net.wanho.dao.impl;

import net.wanho.dao.CustomerDao;
import net.wanho.entiy.Customer;
import net.wanho.entiy.mapper.CustomerMapper;
import net.wanho.util.JDBCTemplate;
import net.wanho.util.RowMapper;

public class CustomerDaoImpl implements CustomerDao {
	
	private JDBCTemplate jdbcTemplate = new JDBCTemplate();
	private RowMapper<Customer> rm = new CustomerMapper();
	
	private static final String UPDATE_SQL = 
			"update customer set name = ?, account = ?, password = ?, balance = ? where id = ?";
	private static final String QUERY_BY_ACCOUNT_SQL = 
			"SELECT id, name, account, password, balance from customer where account = ?";
	
	@Override
	public int update(Customer customer) {
		return jdbcTemplate.update(UPDATE_SQL, customer.getName(), customer.getAcccount(), 
				customer.getPassword(), customer.getBalance(), customer.getId());
	}

	@Override
	public Customer findByAccount(String account) {
		return jdbcTemplate.queryForObject(QUERY_BY_ACCOUNT_SQL, rm, account);
	}

}
