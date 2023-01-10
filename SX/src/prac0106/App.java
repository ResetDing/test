package prac0106;

public class App {

	public static void main(String[] args) {
//		Dog dog = new Dog();
//		Peniguin pgn = new Peniguin();
//		master.feed(dog);
//		master.feed(pgn);
		Master master = new Master();
		Pet pet1 = new Dog();
		Pet pet2 = new Penguin();//ÊµÏÖ¶àÌ¬
		master.feed(pet1);
		master.feed(pet2);
		Pet pet = (Cat)master.getPet("3");
	
		master.feed(pet);
		
		Cat cat = new Cat();
		master.play(cat);
		

	}


}
