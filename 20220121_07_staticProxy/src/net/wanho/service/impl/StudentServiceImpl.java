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
		try {
			transactionManager.start();
			System.out.println("StudentService 业务处理。。。");
			transactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback();
		} 
	}
	
	public void f1() {
		try {
			transactionManager.start();
			System.out.println("StudentService f1业务处理。。。");
			transactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback();
		} 
	}

}
