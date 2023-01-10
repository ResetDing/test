
public class Dog extends Animal {
	
	public void voice() {
		System.out.println("¹·¹·µÄ½ÐÉùÊÇÍôÍôÍô");
	}
	
	public void eat() {
		System.out.println("¹·¹·°®³Ô¹ÇÍ·");
	}
	
	public Dog() {
		super.Animal("à½à½",2);
	}
	
	public static void main(String[] args) {
		Dog d=new Dog();
		
		d.voice();
		d.eat();
		
		d.setName("à½à½");
		d.setAge(4);
		
		System.out.println(d.toString());
	}



}
