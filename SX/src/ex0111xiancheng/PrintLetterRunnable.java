package ex0111xiancheng;

public class PrintLetterRunnable implements Runnable{
	private MyBusiness myBusiness;
	
	public PrintLetterRunnable(MyBusiness myBusiness) {
		this.myBusiness=myBusiness;
	}
	
	public void run() {
		myBusiness.printLetters();
	}

}
