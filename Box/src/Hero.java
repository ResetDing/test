
public class Hero {
	
	String name;
	float hp;
	float armor;
	int moveSpeed;
	
	public Hero(String name) {
		this.name=name;
		System.out.println(name);
	}
	
	public Hero(String name,float hp) {
		this(name);
		System.out.println("两个参数的构造方法");
		this.hp=hp;
	}
	
	public static void main(String[] args) {
		Hero teemo=new Hero("提莫",383);
		System.out.println(teemo.hp);
		
	}

}
