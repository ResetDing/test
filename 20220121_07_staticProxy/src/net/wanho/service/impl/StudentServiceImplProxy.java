package net.wanho.service.impl;

import net.wanho.service.StudentService;
import net.wanho.trans.TransactionManager;
import net.wanho.trans.TransactionManagerImpl;

public class StudentServiceImplProxy implements StudentService {
	
	private StudentService target = new StudentServiceImpl();
	private TransactionManager transactionManager = new TransactionManagerImpl();

	@Override
	public void myBusiness() {
		try {
			transactionManager.start();
			target.myBusiness();
			transactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback();
			throw new RuntimeException(e);
		}
	}
}
