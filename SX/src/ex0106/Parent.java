package ex0106;

public class Parent {
	
	private Integer i;
	
	public Parent() {
		this(10);
		System.out.println("������޲ι���ִ����");
	}
	
	public Parent(int i) {
		this.i=i;
		System.out.println("����Ĺ��췽����������");
	}

}
