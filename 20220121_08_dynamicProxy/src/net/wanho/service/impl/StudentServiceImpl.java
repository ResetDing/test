package net.wanho.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import net.wanho.service.StudentService;
import net.wanho.trans.TransactionManager;
import net.wanho.trans.TransactionManagerImpl;
import net.wanho.util.DBUtil;

public class StudentServiceImpl implements StudentService {
	
	private TransactionManager transactionManager = new TransactionManagerImpl();

	@Override
	public void myBusiness() {
		System.out.println("StudentService myBusiness()业务处理。。。");
	}
	
	public void f1() {
		System.out.println("StudentService f1（）业务处理。。。");
	}

}
