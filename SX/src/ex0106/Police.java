package ex0106;

public class Police {
	
	private Integer age;
	private String name;
	
	public Police(String name) {
		this.name=name;
	}
	
	public void jidu(Detectable detectable) {
		System.out.println(name+"���ż���Ȯ�����ֳ�");
		detectable.detect();
		System.out.println("�ն�");
	}

}
