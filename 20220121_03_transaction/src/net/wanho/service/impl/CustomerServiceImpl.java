package net.wanho.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import net.wanho.dao.CustomerDao;
import net.wanho.dao.impl.CustomerDaoImpl;
import net.wanho.entiy.Customer;
import net.wanho.service.CustomerService;
import net.wanho.util.DBUtil;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public boolean transfer(String fromAccount, String toAccount, Double money) {
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			System.out.println("Service.connection:" + connection.hashCode());
			connection.setAutoCommit(false);
			
			// 转出账号扣钱
			Customer fromCustomer = customerDao.findByAccount(fromAccount);
			fromCustomer.setBalance(fromCustomer.getBalance() - money);
			int fromRows = customerDao.update(fromCustomer);
			if (fromRows == 0) {
				return false;
			}
			
			int i = 1 / 0;
			
			// 转入账号加钱
			Customer toCustomer = customerDao.findByAccount(toAccount);
			toCustomer.setBalance(toCustomer.getBalance() + money);
			int toRows = customerDao.update(toCustomer);
			if (toRows == 0) {
				return false;
			}
			
			connection.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close(connection, null);
		}
		
		return true;
	}

}
