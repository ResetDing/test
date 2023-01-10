package ex0106;

public class Parent {
	
	private Integer i;
	
	public Parent() {
		this(10);
		System.out.println("父类的无参构造执行了");
	}
	
	public Parent(int i) {
		this.i=i;
		System.out.println("父类的构造方法被调用了");
	}

}
