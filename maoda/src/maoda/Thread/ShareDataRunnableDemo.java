package maoda.Thread;

public class ShareDataRunnableDemo
{

	public static void main(String[] args)
	{
		TicketRunnable runnable=new TicketRunnable();//实例化卖票接口,不同于继承，只创建了1个对象
		
		//两个线程是完成runnable一个任务对象。
		Thread t1=new Thread(runnable,"一号窗口");//分配线程1卖票
		t1.start();
		Thread t2=new Thread(runnable,"二号窗口");//分配线程2卖票
		t2.start();
	}

}


//Thread 1，2 操作的是TicketRunnable，同一个对象
class TicketRunnable implements Runnable{
private int ticket = 5;
public void run()
{
	while(true) {
		System.out.println(Thread.currentThread().getName()+":"+(ticket--));
		if(ticket<1) {
			break;
		}
		
		
	}
}
}