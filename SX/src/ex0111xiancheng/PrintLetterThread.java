package ex0111xiancheng;

public class PrintLetterThread extends Thread {
	
	private MyBusiness myBusiness;
	
	public PrintLetterThread(MyBusiness myBusiness) {
		this.myBusiness=myBusiness;
	}
	
	public void run() {
		myBusiness.printLetters();
	}
	
	

}
