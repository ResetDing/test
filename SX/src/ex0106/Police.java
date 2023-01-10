package ex0106;

public class Police {
	
	private Integer age;
	private String name;
	
	public Police(String name) {
		this.name=name;
	}
	
	public void jidu(Detectable detectable) {
		System.out.println(name+"带着缉毒犬来到现场");
		detectable.detect();
		System.out.println("收队");
	}

}
