
public class Person {
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void talk() {
		System.out.println("我是："+name);
		System.out.println("今年："+age+"岁");
	}
	
	public static void main(String[] args) {
		Person p=new Person();
		
		p.setName("张三");
		p.setAge(18);
		
		p.talk();
		
	}

}
