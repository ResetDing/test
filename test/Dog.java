
public class Dog extends Animal {
	
	public void voice() {
		System.out.println("�����Ľ�����������");
	}
	
	public void eat() {
		System.out.println("�������Թ�ͷ");
	}
	
	public Dog() {
		super.Animal("��",2);
	}
	
	public static void main(String[] args) {
		Dog d=new Dog();
		
		d.voice();
		d.eat();
		
		d.setName("��");
		d.setAge(4);
		
		System.out.println(d.toString());
	}



}
