package maoda;

public class IndexOfDemo
{

	public static void main(String[] args)
	{
		String password ="ppnn13%dkstFeb.1st13";
		System.out.println(password.indexOf("13"));
		System.out.println(password.indexOf("13", 2));
		System.out.println(password.indexOf("13", 5));
		System.out.println(password.indexOf("13x", 1));//没查到时返回值是多少？
		System.out.println(password.lastIndexOf("13"));
		System.out.println(password.substring(4, 6));
		System.out.println(password.substring(4));
		System.out.println(password.contains("13"));
	}

}
