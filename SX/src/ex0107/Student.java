package ex0107;

public class Student {
	private Integer age;
	private String name;
	
	public static int numberOfStudent;

	public Student(Integer age, String name) {
		this.age = age;
		this.name = name;
		numberOfStudent++;
	}	
	
	public static void showNum() {
		System.out.println(numberOfStudent);
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
