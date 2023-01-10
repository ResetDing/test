package maoda.RPG;

public class Ranger extends LongRangeHero{

	
	
	
	
	public Ranger(long id, String name, int x,int y)
	{
		setId(id);
		setName(name);
		setX(x);
		setY(y);
		
	}

	public boolean canFightByDistance(Hero hero)
	{
		double distance = getDistance(getX(),getY(),hero.getX(),hero.getY());
		return distance <= 1000;//游侠攻击距离1000
	}

	@Override
	public void fight(Hero hero)
	{
		//1.生成随机攻击力
		//2.减掉传入英雄对象的hp
		int attack =(int)(Math.random()*1000)%51+10; //10-60之间浮动
		setAttack(attack);
		hero.setHp(hero.getHp()-attack);
		
		
	}
	
	

}
