
public class Cat extends Animal {
	private String name;
	private String sex;
	private int age;
	
	public void voice() {
		System.out.println("猫咪的叫声是喵喵喵");
	}
	
	public void eat() {
		System.out.println("猫咪爱吃小鱼干");
	}
	
	public Cat() {
		super.Animal("黑陀",2);
	}
	
	public Cat(String name,String sex,int age) {
		this.name=name;
		this.sex=sex;
		this.age=age;
		System.out.println(name+age+sex);
		
		super.talk();
	}
	
	public void talk() {
		System.out.println("子类的talk方法执行了");
	}
	
	public static void main(String[] args) {
		Cat c=new Cat();
		
		c.voice();
		c.eat();
		
		c.setName("黑陀");
		c.setAge(11);
		
		System.out.println(c.toString());
		
		Cat d=new Cat("黑陀","公",11);
		
		d.talk();
	}

}
