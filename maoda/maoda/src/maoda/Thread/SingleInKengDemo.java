package maoda.Thread;

public class SingleInKengDemo
{

	public static void main(String[] args)
	{
//		 SingleInKeng.getInstance();
//		 SingleInKeng.getInstance();
			SThread sThread=new SThread();
			Thread St1=new Thread(sThread);
			St1.start();
			Thread St2=new Thread(sThread);
			St2.start();
	}
}

class SingleInKeng
{
	private static SingleInKeng singleInKeng=null;
	private SingleInKeng() {
		System.out.println("单例模式");
	}

public static SingleInKeng getInstance() {//用静态，也就是全局变量，那就不需要实例化直接可以在外部调用内部对象
	
	synchronized (SingleInKeng.class) {//老板我要配锁,唯一的一个类，锁也是唯一的
	if(singleInKeng==null) {
		singleInKeng=new SingleInKeng();//为空时创建1个对象，创建后就没法再建了。所谓的唯一。
	}

	return singleInKeng;
	}
}
}

class SThread implements Runnable{

	@Override
	public void run()
	{
		SingleInKeng.getInstance();
		
	}
	
}
