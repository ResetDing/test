package maoda.RPG2;

public class Warrior extends Hero
{
	public Warrior()
	{
		super();//子类中调用父类的方法
		setName("默认英雄");
	}
	
	public Warrior(long id,String name,int x,int y,int attack) {
		super(id,name);
		setX(x);
		setY(y);
		setAttack(attack);
	}
	
	@Override
	public boolean canFightByDistance(Assailable hero)
	{
		double distance = getDistance(getX(),getY(),hero.getX(),hero.getY());
		return distance <= 100;//战士手短，100之内才能攻击，才能true canFight
	}

	@Override
	public void fight(Assailable hero)
	{
		//1.生成随机攻击力
		//2.减掉传入英雄对象的hp
//		int attack =(int)(Math.random()*1000)%51+20; //20-70之间浮动
//		setAttack(attack);
//		hero.setHp(hero.getHp()-attack);
		hero.setHp(hero.getHp()-getAttack());
		
		
	}

}
