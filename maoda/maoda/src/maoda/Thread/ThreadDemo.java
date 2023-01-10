package maoda.Thread;

public class ThreadDemo
{

	public static void main(String[] args)
	{
		HelloThread h1=new HelloThread("a");//实例化运行程序用1线程
		HelloThread h2=new HelloThread();
//		h1.setName("线程1");//可以用setName来自己定义线程名称
		h2.setName("线程2");
		h1.start();
		h2.start();
	}

}
	 class HelloThread extends Thread{
		 
		 public HelloThread() {//无参构造可以用上面setName来自定义线程名称
			 
		 }
		 
		 public HelloThread(String name) {//也可以用有参构造，达到自定义线程名称
			 super(name);				//看api书里，父类Thread有string构造
		 }
		 
		 
		public void run() {
			for(int i=0;i<=5;i++)
			{
				//因为是继承的，直接用父类里的getName方法，获取线程名字
				System.out.println(this.getName()+":"+i);//打印调用线程的线程名称+打印内容
			}
			
			
		}
	}