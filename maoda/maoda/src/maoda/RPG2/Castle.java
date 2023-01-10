package maoda.RPG2;
//主城
public class Castle implements Assailable
{
	private String name;
	private int x;
	private int y;
	private int maxHp;
	private int hp;
	private int attackrange;
	
	public Castle(long id,String name,int x,int y) {
		setName(name);
		setX(x);
		setY(y);
		setHp(777);
		setAttackrange(500);//设定攻击范围
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
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
	public int getAttackrange()
	{
		return attackrange;
	}
	
	protected double getDistance(int x1,int y1,int x2,int y2) {
		return Math.sqrt(Math.abs(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)));
	}
	
	public void setAttackrange(int attackrange)
	{
		this.attackrange = attackrange;
	}
	@Override
	public boolean canFightByDistance(Assailable assa)
	{
		//1.计算与另一个可攻击对象之间距离
		//2.如果距离可以，则攻击
		double distance = getDistance(getX(),getY(),assa.getX(),assa.getY());
		return distance <= attackrange;
		
	}
	
	@Override
	public void fight(Assailable assa)
	{
		// 假设城堡攻击力，固定数值
		int attack =15;
		assa.setHp(assa.getHp()-attack);
		
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
	
}
