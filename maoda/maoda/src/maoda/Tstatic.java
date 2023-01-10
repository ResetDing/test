package maoda;

class Tstatic
{
	static int i;

	public Tstatic()
	{
		i = 4;
	}

	public Tstatic(int j)
	{
		i = j;
	}

	public static void main(String args[])
	{
		Tstatic tt = new Tstatic(5);
		Tstatic t = new Tstatic(6); // 声明对象引用，并实例化
		 // 全局变量i，2对象都在巴结它！
		System.out.println(t.i);//4
		System.out.println(tt.i); //4
		System.out.println(t.i);//4
		System.out.println(t.i==tt.i);//t对象中的i对比
		System.out.println(t==tt);//f两对象对比
	}
}