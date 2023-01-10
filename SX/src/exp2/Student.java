package exp2;

public class Student {
	
	private Integer age;
	private String name;
	private String phone;
	
	public Student() {
	}
	
	public Student(Integer age,String name,String phone) {
		this.age=age;
		this.name=name;
		this.phone=phone;
	}
	
	public String toString() {
		return "年龄："+age+"，姓名："+name+"，手机号："+phone;
	}

	public int getAge() {
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

	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void selfIntroduce() {
		System.out.println("大家好，我叫"+name);
	}

	

}
