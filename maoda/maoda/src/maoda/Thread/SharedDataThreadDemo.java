package maoda.Thread;

public class SharedDataThreadDemo
{

	public static void main(String[] args)
	{	//两个线程分别运行2个新的任务对象。
		TicketThread s1=new TicketThread("一号窗口");//弊端，TicketThread实例化了2个5张票。
		s1.start();
		TicketThread s2=new TicketThread("二号窗口");//弊端，一号窗口有5张，二号也有5张
		s2.start();

	}

}
//操作的是两个新建的对象。当然现实中也可以，按需求来编写。不同电影院就不同共享对象。
class TicketThread extends Thread{
	
	private int ticket = 5;

	public TicketThread(String name) {
		super(name);
	}
	
	public void run()
	{
		while(true) {
			System.out.println(this.getName()+":"+(ticket--));
			if(ticket<1) {
				break;
			}
			
			
		}
	}
	
}