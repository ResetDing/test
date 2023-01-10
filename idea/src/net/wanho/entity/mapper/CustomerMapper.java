package net.wanho.entity.mapper;

import net.wanho.entity.Customer;
import net.wanho.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer rowMap(ResultSet resultSet) {
        Customer customer = new Customer();
        try {
            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            customer.setAccount(resultSet.getString("account"));
            customer.setPassword(resultSet.getString("password"));
            customer.setBalance(resultSet.getBigDecimal("balance"));
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
