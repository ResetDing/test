package maoda.Thread;

	
	 
	public class DeadTest {
		
		public static void main(String[] args) {
			DeadThread dt=new DeadThread();
			new Thread(dt,"小喵喵").start();
			new Thread(dt,"深渊骑士").start();
		}
	}
	 
	class DeadThread implements Runnable{
		private Object o1=new Object();
		private Object o2=new Object();
		
		public void run() {
			if(Thread.currentThread().getName().equals("小喵喵")){
				method1();
			}else{
				method2();
			}
		}
		
		public void method1(){
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName()+"haha,我拿到o1锁");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("我执行完了");
				}
			}
		}
		
		public void method2(){
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName()+"haha,我拿到o2锁");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("我执行完了");
				}
			}
		}
		
	}


