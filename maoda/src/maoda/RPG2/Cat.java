package maoda.RPG2;

public class Cat implements Eat, Eat1,Eat2//猫类接上"吃"的能力。
{
	
	@Override
	public void eatingApple()//重写接口的方法
	{
		System.out.print(this.name+"不吃苹果！");
		
	}
	
	String name="小喵喵";
	
	
	
	void fight() {//普通方法
		System.out.print(this.name+"fight with 深渊骑士");
	}



}
