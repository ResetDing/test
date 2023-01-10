package ex0111xiancheng;

public class TicketService {
	
	private int num = 100;
	
	
	public synchronized void refund() {
		
		if (num >= 100) {
			try {
				
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		num++;
		System.out.println("��Ʊ�ɹ�����Ʊ:" + num);
		
		this.notify();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void sellTicket() {
		if (num <= 0) {
			try {
				
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (num <= 0) {
			return;
		}
		num--;
		String name = Thread.currentThread().getName();
		System.out.println(name + "ʲôʲô��:" + num);
		
		
		this.notify();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	public boolean hasTicket() {
		return num > 0;
	}
	
	public boolean canRefund() {
		return num < 100;
	}
}
