package maoda.Thread;
/**
 * 模拟银行取钱,来理解同步Synchronize,进程优先级
 * @author MAOU
 *
 */
public class SynchronizeDemo
{
	public static void main(String[] args) {
		Bank bank=new Bank();
		BankThread p1=new BankThread(bank,"柜台1");//比如一个是网上取钱，另一个柜台取
		p1.start();
		BankThread p2=new BankThread(bank,"柜台2");
		p2.start();
		
		
	}
	
}

class BankThread extends Thread{//创建取钱流程的线程类
	private Bank bank=null;
	public BankThread(Bank bank, String name) {
		this.bank=bank;
		 this.setName(name);
	}
	public void run() {
		System.out.println(this.getName()+"取钱："+bank.getMoney(400));//
	}
}


class Bank{
	private int money=500;//账号里有500块
	private Object key1=new Object();
	private Object key2=new Object();
//	public synchronized int getMoney(int number) {
	//其他线程当调用同步方法时，只能等
	
	public int getMoney(int number) {
		synchronized(key2) {
		if (number<0) {//取钱肯定是正数
			return -1;//return值为负数，经常用于异常报错。
		}else if(money<0) {//没钱不能取
			return -2;
		}else if(number-money>0) {//取钱不能超过余额，不能透支
			return -3;
		}
		else {
			try
			{
				Thread.sleep(1000);//休眠，取钱间隔(罪魁祸首) 准备扣钱的时候，另一端已经提出了取钱的申请
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			money-=number;//三条件都满足，就扣钱
			System.out.println("余额："+money);
		
		return number;
			}
	}
		
		
	
		/**
		 * 同步模块
		 */
		
//		synchronized (this) {//给当前模块加锁
//			//里面加的方法，就加上了同步锁
//		}
		//小心死锁，2个进程，a需要b的锁才能进行，b需要a的锁才能进行，导致2个进程都不能进行
		
	}
	
}