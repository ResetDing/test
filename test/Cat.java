
public class Cat extends Animal {
	private String name;
	private String sex;
	private int age;
	
	public void voice() {
		System.out.println("è��Ľ�����������");
	}
	
	public void eat() {
		System.out.println("è�䰮��С���");
	}
	
	public Cat() {
		super.Animal("����",2);
	}
	
	public Cat(String name,String sex,int age) {
		this.name=name;
		this.sex=sex;
		this.age=age;
		System.out.println(name+age+sex);
		
		super.talk();
	}
	
	public void talk() {
		System.out.println("�����talk����ִ����");
	}
	
	public static void main(String[] args) {
		Cat c=new Cat();
		
		c.voice();
		c.eat();
		
		c.setName("����");
		c.setAge(11);
		
		System.out.println(c.toString());
		
		Cat d=new Cat("����","��",11);
		
		d.talk();
	}

}
