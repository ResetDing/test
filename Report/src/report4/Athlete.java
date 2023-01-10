package report4;


public class Athlete implements Runnable{
	
	private int X=20;

	public void run() {
		while (true)
		{		
		synchronized (Athlete.class) {
		if(X>0)
		{
			System.out.println(Thread.currentThread().getName()+":"+X--);
			try
			{
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
		
}
	
}
