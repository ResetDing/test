package maoda.RPG2;

/**
 * 实现了可被攻击的抽象类,可攻击接口的英雄类。
 * 
 * @author MAOU
 *
 */
public abstract class Hero implements Assailable
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
	
	public void PK(Assailable assa) {
		//1.判断两者距离
		//2.如果满足，进行攻击
		if(canFightByDistance(assa)&& hp>0 && assa.getHp()>0)//assa.getHp是获取可被攻击对象的血
		{
			fight(assa);
		}
		//3.打印对战结果
		else {
			System.out.println("打不到够不到哟");
		}
		System.out.println("两位英雄的当前状态");
		System.out.println("昵称\tHP\tX坐标\tY坐标");
		System.out.println(name+"\t"+hp+"\t"+x+"\t"+y);
		System.out.printf("%s\t%d\t%d\t%d",
		assa.getName(),assa.getHp(),assa.getX(),assa.getY());
	}
	
	
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
		this.level = level;
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
