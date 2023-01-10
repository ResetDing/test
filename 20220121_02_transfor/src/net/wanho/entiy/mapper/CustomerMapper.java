package net.wanho.entiy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.wanho.entiy.Customer;
import net.wanho.util.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer rowMap(ResultSet rs) {
		try {
			Integer id = rs.getInt("id");
			String name = rs.getString("name");
			String account = rs.getString("account");
			String password = rs.getString("password");
			Double balance = rs.getDouble("balance");
			
			Customer c = new Customer();
			c.setId(id);
			c.setName(name);
			c.setAcccount(account);
			c.setPassword(password);
			c.setBalance(balance);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
