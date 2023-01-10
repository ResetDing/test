package maoda.Exception;

public class ExceptionDemo
{
	public static int division(int num1,int num2) {
		int result=Integer.MIN_VALUE;
//		result=num1/num2;
		try {				//监控有可能出现异常的语句块，所以说试试看
			result=num1/num2;
		}
		
		//还有个finally{程序段}不管有没有异常，一定会执行语句块
		catch(Exception e) {   //捕获到了e为异常，然后打印,
			e.printStackTrace();//以堆栈跟踪的形式打印异常,错误追溯到源头
			System.err.println("异常信息："+e.getMessage());
		}
		return result; //result只有初始化，并没有计算，所以是整型最小值-2147....
	}


public static void main(String[] args) {
	int result = division(5,0);
	System.out.println("result="+result);
}


}