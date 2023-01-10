package prac0104;
/**
 * 
 * 定义方法，进制转换，参数为十进制的数值和转换进制的底。转换结果为字符串，超出9的数字用大写字母依次代替。
输入：num, b
输出：以b为底的进制数
 *
 */

public class zy06{
	
	public static void main(String[] args) {
		String result=convert(5,2);        //前面是数字，后面是进制数
		System.out.println(result);
	}
	
	public static String convert(int num,int base) {
		String result="";
		while(num>0) {
			int reminder=num%base;
			result=reminder+result;   //字符串连接
			num=num/base;
		}
		return result;
	}
	
	
	
}




/*
 * 
 
public class zy06 {

	public static void main(String[] args)
	{
		System.out.println("100的二进制是："+Integer.toBinaryString(100));
		System.out.println("100的八进制是："+Integer.toOctalString(100));
		System.out.println("100的十六进制是："+Integer.toHexString(100));
		System.out.println("100的二十进制是："+Integer.toString(100, 20));
	}

}


*/
