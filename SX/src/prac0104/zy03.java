package prac0104;
/**
 * 
 *定义方法，实现不定次数打印
分析：定义方法实现功能，需要有两个明确，即返回值和参数。
明确返回值：方法中打印出HelloWorld即可，没有计算结果，返回值类型	。
明确参数：打印几次不清楚，参数定义一个整型参数
 *
 */



public class zy03 {

	public static void main(String[] args)
	{
		printHelloWorld(10);          //调用方法printHelloWorld，传递整数 
	}
	
	public static void printHelloWorld() { //重载，不输入几次就输出5次
		printHelloWorld(5); 
	}
	
		
	//定义打印HelloWorld方法 返回值类型，计算没有结果 void 参数：不确定打印几次 
	public static void printHelloWorld(int n) { 
		for (int i = 0; i < n; i++) { 
			System.out.println("HelloWorld"); 
		}
	}

}
