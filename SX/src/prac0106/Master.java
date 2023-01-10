package prac0106;

public class Master {
//	public void feed(Dog dog) {
//	dog.eat();
//}
//public void feed(Peniguin pgn) {
//	pgn.eat();
//}
	public void feed(Pet pet) {
		pet.eat();
		}
	
	public void play(Pet pet) {
		if(pet instanceof Dog) {
			Dog dog = (Dog)pet;
			dog.catchingFlyDisc();
			}else if(pet instanceof Penguin) {
				Penguin pgn = (Penguin)pet;
				pgn.swimming();
				}else {
					System.out.println("功能开发中。。。");
					}
		}
/**
 * 
 * @param typeId 1:Dog 2:Penguin 3:Cat
 * @return
 */
	public Pet getPet(String typeId) {
		switch(typeId) {
		case"1":
			return new Dog();
		case"2":
			return new Penguin();
		case"3":
			return new Cat();
		default:
			System.out.println("typeId不正确");
			return null;
	}
}


	


}
