package net.wanho.proxy;

import org.junit.Test;

import net.wanho.service.StudentService;
import net.wanho.service.impl.StudentServiceImpl;

public class TransactionProxyTest {

	@Test
	public void test() {
		StudentService studentService = new StudentServiceImpl();
		StudentService proxy = (StudentService) TransactionProxy.createProxy(studentService);
		proxy.myBusiness();
		proxy.f1();
	}

}
