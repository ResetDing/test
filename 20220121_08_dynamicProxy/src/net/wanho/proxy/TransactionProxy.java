package net.wanho.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.wanho.trans.TransactionManager;
import net.wanho.trans.TransactionManagerImpl;

/**
 * 事务的代理
 * @author liuke
 *
 */
public class TransactionProxy {
	
	private static TransactionManager transactionManager = new TransactionManagerImpl();
	/**
	 * 得到一个代理对象 （可以进行事务管理的代理）
	 * @param targe
	 * @return
	 */
	public static Object createProxy (Object targe) {
		Object proxy = Proxy.newProxyInstance(
				targe.getClass().getClassLoader(),
				targe.getClass().getInterfaces(), 
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object result = null;
						try {
							transactionManager.start();
							result = method.invoke(targe, args);
							transactionManager.commit();
						} catch(Exception e) {
							e.printStackTrace();
							transactionManager.rollback();
							throw new RuntimeException(e);
						}
						return result;
					}
				});
		return proxy;		
	}

}
