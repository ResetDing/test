
public class Animal {
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
	
	public String toString() {
		return "它的名字叫"+name+"今年"+age+"岁了";
	}
	
	public void Animal(String name,int year) {
		this.name=name;
		this.age=year+age;
		System.out.println(name+year+"年后"+(year+11)+"岁");
		
	}
	
	public void talk() {
		System.out.println("父类的talk方法执行了。");
	}

}
