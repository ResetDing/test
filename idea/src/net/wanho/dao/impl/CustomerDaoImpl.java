package net.wanho.dao.impl;

import net.wanho.dao.CustomerDao;
import net.wanho.entity.Customer;
import net.wanho.entity.mapper.CustomerMapper;
import net.wanho.util.JDBCTemplate;
import net.wanho.util.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private static String UPDATE_SQL =
            "UPDATE customer set name = ?, account = ?, password = ?, balance = ? where id = ?";
    private JDBCTemplate jdbcTemplate = new JDBCTemplate();
    RowMapper<Customer> rowMapper = new CustomerMapper();

    @Deprecated
    @Override
    public Customer login(String account, String password) {
        String sql = "select * from customer where account = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, rowMapper, account);
        if (customer != null && customer.getPassword().equals(password)){
            return customer;
        }

        // TODO 加积分
        // TODO  记录登录日志

        return null;
    }

    @Override
    public Customer findByAccount(String account) {
        String sql = "select * from customer where account = ? ";
        return jdbcTemplate.queryForObject(sql, rowMapper, account);
    }

    public int update(Customer customer){
        return jdbcTemplate.update(UPDATE_SQL, customer.getName(), customer.getAccount(),
                customer.getPassword(), customer.getBalance(), customer.getId());
    }

}
