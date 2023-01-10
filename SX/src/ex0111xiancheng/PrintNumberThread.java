package ex0111xiancheng;

public class PrintNumberThread extends Thread {
	
	private MyBusiness myBusiness;
	
	public PrintNumberThread(MyBusiness myBusiness) {
		this.myBusiness=myBusiness;
	}
	
	public void run() {
		myBusiness.printNumbers();
	}

}
