package prac0104;
/**
 * 
 *定义方法，计算1+2+3...+100的和。
分析：定义方法实现功能，需要有两个明确，即返回值和参数。
明确返回值：1~100的求和，计算后必然还是整数，返回值类型是int 
明确参数：需求中已知到计算的数据，没有未知的数据，不定义参数
 *
 */
public class zy04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=sum();
		System.out.println("1~100的和是"+a);

	}
	
	public static int sum() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			sum+=i;
		}
		return sum;
	}

}
