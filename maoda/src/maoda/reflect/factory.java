package maoda.reflect;

public class factory
{
	public static fruit getInstance(String ClassName)
	{
		fruit f = null;//初始化一下
		try
		{
			//获取类名，是什么类就获取什么类的单例,注意设计时候父类要用抽象类
			f = (fruit) Class.forName(ClassName).newInstance();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
}