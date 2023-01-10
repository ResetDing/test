package net.wanho.service.impl;

import net.wanho.dao.CustomerDao;
import net.wanho.dao.LoginLogDao;
import net.wanho.dao.impl.CustomerDaoImpl;
import net.wanho.dao.impl.LoginLogDaoImpl;
import net.wanho.entity.Customer;
import net.wanho.entity.LoginLog;
import net.wanho.service.CustomerService;

import java.math.BigDecimal;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();
    LoginLogDao loginLogDao = new LoginLogDaoImpl();

    @Override
    public boolean login(String account, String password) {
        // 校验用户名密码
        Customer customer = customerDao.findByAccount(account);
        if (customer == null){
            return false;
        }
        if (!customer.getPassword().equals(password)){
            return false;
        }
        // 加积分
        BigDecimal oldBalance = customer.getBalance();
        customer.setBalance(oldBalance.add(new BigDecimal(50)));
        customerDao.update(customer);
        // 插入登录日志
        LoginLog loginLog = new LoginLog();
        loginLog.setAccount(account);
        loginLogDao.insert(loginLog);

        return true;
    }


}
