package maoda;

public class Hero
{
	private long id;
	private String name;
	private int level;
	private long exp;
	private long curexp;
	
	public Hero()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	class Weapon{
		public void fight(){
			System.out.println(id);
		}
	}
	
	public Hero(String name) {
		if(null == name)
		{name = "小喵喵";}
	else
		{this.name = name;}
	}
	
	public Hero(long id, String name, int level, long exp)
	{
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.exp = exp;
	}


	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		if(id <= 0) id = 1;
		else
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	
	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		if(level <1  || level> 999)
		{	this.level = 1;
		}
		else
		{
		this.level = level;
		}
	}

	public long getExp()
	{
		exp =((long)Math.pow(level - 1, 3) + 60)/5*((level - 1)*2+60);
		return exp;
	}

	public long getCurexp()
	{
		return curexp;
	}

	public void setCurexp(long curexp)
	{
		this.curexp = curexp;
	}


}
