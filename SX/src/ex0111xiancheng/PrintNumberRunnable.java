package ex0111xiancheng;

public class PrintNumberRunnable implements Runnable{
	private MyBusiness myBusiness;
	
	public PrintNumberRunnable(MyBusiness myBusiness) {
		this.myBusiness=myBusiness;
	}
	
	public void run() {
		myBusiness.printLetters();
	}

}
