package net.wanho.service;

import net.wanho.entity.Customer;
import net.wanho.service.impl.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class CustomerServiceTest {

    CustomerService customerService = new CustomerServiceImpl();

    @Test
    public void testLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String account = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        boolean b = customerService.login(account, password);
        System.out.println(b);
    }
}
