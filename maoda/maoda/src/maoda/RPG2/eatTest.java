package maoda.RPG2;

public class eatTest
{

	public static void main(String[] args)
	{
//		Eat eat=new Eat();//创造一个吃？接口本身不能实例化
		Cat cat =new Cat();//创造一只猫
		cat.eatingFish(); //用接口内部的方法
		cat.eatingShrimp();//用接口内部的方法
		cat.eatingApple();//用重写接口的方法
		cat.fight();//用自己的方法
		
	}

}
