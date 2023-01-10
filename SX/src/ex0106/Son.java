package ex0106;

public class Son extends Parent {

	private Integer i;
	
	public Son() {
		super(1);
		this.i=i;
		System.out.println("子类的无参构造被执行了");
	}
	
	public Son(int i) {
		this.i=i;
		System.out.println("子类的有参构造执行了");
	}
	
	
}
