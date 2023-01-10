package net.wanho.dao;

import net.wanho.dao.impl.CustomerDaoImpl;
import net.wanho.entity.Customer;
import org.junit.Test;

import java.util.Scanner;

public class CustomerDaoTest {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Test
    public void test1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String account = sc.nextLine();
    }

    @Test
    public void testLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String account = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();
        System.out.println(account + " " + password);
        Customer c = customerDao.login(account, password);
        if (c != null){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败，用户名或密码不正确 ");
        }
    }
}
