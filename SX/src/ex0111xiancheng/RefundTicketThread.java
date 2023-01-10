package ex0111xiancheng;

public class RefundTicketThread extends Thread {
	
	private TicketService ticketService;
	
	public RefundTicketThread(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@Override
	public void run() {
		while(true) {
			ticketService.refund();
		}
	}
	
	

}