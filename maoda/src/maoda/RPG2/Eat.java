package maoda.RPG2;

public interface Eat
{
	default public void eatingFish() {
		System.out.println("小喵喵在厨房偷吃鱼...");
	}
	
}

	interface Eat1
{
	default public void eatingShrimp() {
		System.out.println("小喵喵在厨房偷吃虾...");
	}
}
	
	interface Eat2
	{
		public void eatingApple();
	
	}

