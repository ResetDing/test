package maoda;

public class SingleModeDemo
{
	public int count=0;
	public SingleModeDemo()
	{
		count++;
	}
	public static void main(String[] args)
	{
		SingleModeDemo warrior1=new SingleModeDemo();
		System.out.println(warrior1.count);
		SingleModeDemo warrior2=new SingleModeDemo();
		//理解为，第二次转回战士，如果count不累计，也就是重新开档的坑爹感觉。
		System.out.println(warrior2.count);
		SingleModeDemo warrior3=new SingleModeDemo();
		System.out.println(warrior3.count);
		SingleModeDemo warrior4=new SingleModeDemo();
		System.out.println(warrior4.count);
		

	}

}
