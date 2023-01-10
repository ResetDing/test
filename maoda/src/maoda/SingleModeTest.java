package maoda;

public class SingleModeTest
{

	public static void main(String[] args)
	{
//		SingleModeDemo2 warrior =new SingleModeDemo2(); //方法私有化，所以没法实例化
		SingleModeDemo2 warrior1=SingleModeDemo2.getInstance();//获得实例化warrior1
		System.out.println(warrior1.count);
		warrior1.count++;
		
		SingleModeDemo2 warrior2=SingleModeDemo2.getInstance();//获得第二个实例warrior2
		System.out.println(warrior2.count);//如果是新建的实例，warrior2是新战士，那么count应该是1才对
		warrior2.count++;
		
		
		SingleModeDemo2 warrior3=SingleModeDemo2.getInstance();
		System.out.println(warrior3.count);
		//不管是战士1，还是战士2，无论换多少次职业，原来的warriorMAO
		//不信？
		
		System.out.println(warrior3==warrior1);
	}

}
