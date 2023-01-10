/**
 * 
 * 定义一个方法，计算从1到n的和，并输出结果
 * n代表大于1的整数
 *
 */
public class test11 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=100;
		int a=sum(x,false);
		System.out.println(a);

	}
	
	public static int sum(int n,boolean containsEnd) {
		int result=0;
		if(containsEnd) {
			n++;
		}
		for(int i=1;i<n;i++) {
			result+=i;
		}
		return result;
	}

}
