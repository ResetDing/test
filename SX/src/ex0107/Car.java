package ex0107;

public class Car {
	
	private final Engine engine=new Engine();
	
	private int mode;
	
	public void move() {
		engine.work();
		System.out.println("车子行驶了");
	}
	
	public void setMode() {
		
	}
	
	class Engine{
		public void work() {
			System.out.println("输出动力");
		}
	}

}
