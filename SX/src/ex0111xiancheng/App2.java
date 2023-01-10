package ex0111xiancheng;

public class App2 {

	public static void main(String[] args) {
		System.out.println("main¿ªÊ¼");
		MyBusiness myBusiness=new MyBusiness();
		
		Runnable printLetterRunnable=new PrintLetterRunnable(myBusiness);
		Runnable printNumberRunnable=new PrintNumberRunnable(myBusiness);
		
		Thread t1=new Thread(printLetterRunnable);
		Thread t2=new Thread(printNumberRunnable);
		
		t1.start();
		t2.start();
		
	}

}
