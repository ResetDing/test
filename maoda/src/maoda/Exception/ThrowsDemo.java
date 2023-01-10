package maoda.Exception;

public class ThrowsDemo
{
	
	public static void division(String strNum1,String strNum2) throws NumberFormatException
	{
		int num1=Integer.parseInt(strNum1);//进入parseInt，它本身源码也用throws，可以看到他用哪个类型的异常诊断
		int num2=Integer.parseInt(strNum2);//追溯源码，是runtime异常，所以免检的
		int result =num1/num2;
		System.out.println("result="+result);
	}
	
	public static void main(String[] args) 
	{
		division("123","hhh");
	
		System.out.println("程序正常结束：");
		

	}

}
