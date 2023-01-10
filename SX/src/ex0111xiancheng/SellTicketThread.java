package ex0111xiancheng;

public class SellTicketThread extends Thread {
	
	private TicketService ticketService;
	
	public SellTicketThread(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	
	public void run() {
		while(true) {
			ticketService.sellTicket();
		}
	}
	
	

}