package maoda;

public class SingleModeDemo2
{
	private static SingleModeDemo2 warriorMAO =null;//初始化一个战士MAO
	
	
	
	public int count=0;
	private SingleModeDemo2()//定义私有的方法，那么外面的test就没法实例化了
	{
		count++;
	}
	
	/**
	 * 获得本类唯一的一个实例。单例mode
	 * @return
	 */
	public static SingleModeDemo2 getInstance() {
		if(null==warriorMAO)  //warriorMAO为空，那么唯一的一个实例化在这，别处都不能实例化
			//就是说，那个战士还是那个战士。
		warriorMAO=new SingleModeDemo2();
		return warriorMAO;
	}
	

		

	

}
