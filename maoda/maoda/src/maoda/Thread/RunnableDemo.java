package maoda.Thread;

public class RunnableDemo
{

	public static void main(String[] args)
	{
	 HelloRunnable helloRunnable=new HelloRunnable();
	 Thread t1=new Thread(helloRunnable,"A");
	 t1.start();
	 Thread t2=new Thread(helloRunnable,"B");
	 t2.start();

	}

}


	class HelloRunnable implements Runnable {//用接口来实现多线程，有2个好处
		//1.避免单继承的局限，一个类可以实现多个接口，但只能继承1个类
		//2.适合资源的共享

		@Override
		public void run() {
			for(int i=0;i<=5;i++)
			{	//注意！Runnable是接口，所以不是继承关系，不能直接调用父类的getName，所以用到了手册上的currentThread方法
				System.out.println(Thread.currentThread().getName()+":"+i);//打印调用线程的线程名称+打印内容
			}
		}
	}