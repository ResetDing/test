package ex0111xiancheng;

public class App {
	public static void main(String[] args) {
		MyBusiness myBusiness=new MyBusiness();
		
		Thread printNumberThread= new PrintNumberThread(myBusiness);
		Thread printLetterThread= new PrintLetterThread(myBusiness);
		
		printNumberThread.start();
		printLetterThread.start();
		
		
	}

}
