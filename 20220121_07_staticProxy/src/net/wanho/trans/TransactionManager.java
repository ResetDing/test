package net.wanho.trans;
/**
 * 事务管理器
 * @author liuke
 *
 */
public interface TransactionManager {
	/**
	 * 开启事务
	 */
	public void start();
	
	/**
	 * 提交事务
	 */
	public void commit();
	
	/**
	 * 回滚事务
	 */
	public void rollback();
}
