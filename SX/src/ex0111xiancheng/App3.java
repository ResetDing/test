package ex0111xiancheng;

public class App3 {

	public static void main(String[] args) {
		TicketService ticketService = new TicketService();
		
		Thread t1 = new SellTicketThread(ticketService);
		Thread t2 = new RefundTicketThread(ticketService);
		
		t1.start();
		t2.start();
		System.out.println("mainº¯ÊýÖ´ÐÐ");
	}

}
