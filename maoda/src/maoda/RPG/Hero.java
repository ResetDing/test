package maoda.RPG;

public abstract class Hero
// 当初设计抽象类的目的是，一定要用子类来实例化，
// 也就是说必须要选职业才能玩游戏，不能不选,如果用普通父类，可以不选职业
// 相当于一个游客进了游戏世界，他没有各种职业的能力，只能实现父类的属性比如只能移动
{
	private long id;
	private String name;
	private int level;
	private int maxHp;
	private int hp;
	private int attack;
	private int x; // 玩家所在坐标，如果是2d游戏的话。
	private int y;

	
	public Hero() {
		setMaxHp(100);
		setHp(100);
	}
	
	public Hero(long id, String name) {
		this(); //调用自己的构造，就是调用上面MaxHp和setHp，初始化血
		setId(id);
		setName(name);
		
	}
	
	public void PK(Hero hero) { //真正的对战方式,区别于单纯的攻击
		//1.计算距离能不能攻击对方
		//2.如果可以攻，则调用攻击方式
		//3.打印对战结果
		if(canFightByDistance(hero)&&hp>0&&hero.getHp()>0)
		{fight(hero);}
		else {
			System.out.println("打不到够不到哟");
		}
		System.out.println("两位英雄的当前状态");
		System.out.println("昵称\tHP\tX坐标\tY坐标");
		System.out.println(name+"\t"+hp+"\t"+x+"\t"+y);
		System.out.printf("%s\t%d\t%d\t%d",
				hero.getName(),hero.getHp(),hero.getX(),hero.getY());
	}
	
	public abstract boolean canFightByDistance(Hero hero);//是否能够攻击对方角色
	
	
	
	public abstract void fight(Hero hero);//攻击传入的角色，根据生成的攻击力减少对方hp值
	//为啥定义抽象类？因为每个角色攻击方式都不一样啊，也就是需要子类来实现，
	//打人的方式要具体落实，到底是扔魔法还是用敲打
	//接上面就是首先能不能攻击，如果能，怎么攻
	protected double getDistance(int x1,int y1,int x2,int y2) {
		return Math.sqrt(Math.abs(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)));
	}
	
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		if(level<0||level>100) {
			this.level=1;
		}else {
		this.level = level;
		}
	}

	public int getMaxHp()
	{
		return maxHp;
	}

	public void setMaxHp(int maxHp)
	{
		this.maxHp = maxHp;
	}

	public int getHp()
	{
		return hp;
	}

	public void setHp(int hp)
	{
		
		this.hp = hp;
	}

	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int attack)
	{
		this.attack = attack;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

}
