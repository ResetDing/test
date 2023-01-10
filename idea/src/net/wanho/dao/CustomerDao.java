package net.wanho.dao;

import net.wanho.entity.Customer;

public interface CustomerDao {

    @Deprecated
    public Customer login(String account, String password);

    public Customer findByAccount(String account);

    public int update(Customer customer);
}
