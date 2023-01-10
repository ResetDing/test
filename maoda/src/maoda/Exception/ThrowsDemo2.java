package maoda.Exception;

/**
 * 手动抛出异常
 * 
 * @author MAOU
 *
 */
public class ThrowsDemo2
{

	public static void main(String[] args)
	{
		Hero hero=new Hero("小喵喵");
		try
		{
			hero.setExp(99);
			hero.setHp(-100);
			hero.rideHorse();
		} catch (Exception e)
		{
		
//			e.printStackTrace();
			System.err.print("设置数值时出现异常"+e.getMessage());//不让人家看到在哪出现错误
		}
		System.out.println("当前英雄经验值为"+hero.getExp());
	}

}

class Hero
{
	private String name;
	private long exp;
	private int Hp;
//骑马方法扔一个自定义异常
	public void rideHorse() throws LessThanZeroException {
		if(Hp>=0)
			System.out.println(name+"正在快乐的骑马");
		else 
			throw new LessThanZeroException(Hp);//自定义的异常报错
	}
	
	
	public int getHp()
	{
		return Hp;
	}


	public void setHp(int hp)
	{
		Hp = hp;
	}


	public Hero(String name) {
		setName(name);
	}
	
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getExp()
	{
		return exp;
	}

	public void setExp(long exp) throws Exception
	{
		if(exp>=0)
		this.exp = exp;
		else
			throw new Exception("经验值不能为负数！");
	}

}