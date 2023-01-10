/**
 * 
 *比较两个小数的大小
 *
 */

public class test12{
	
	public static void main(String[] args) {
		int a=compareDouble(3.5,7.9);
		System.out.println(a);
	}
	
	public static int compareDouble(double a,double b) {
		if(a>b) {
			return 1;
		}else if(a==b){
			return 0;
		}
		return -1;
	}
	
	
}










/**
 * 比较两个整数的大小，a>b返回1，相等返回0，a<b返回-1
 
public class test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=compareInt(1,2);
		System.out.println(result);

	}
	
	public static int compareInt(int a,int b) {
		
		if(a>b) {
			return 1;
		}else if(a==b){
			return 0;
		}else{
			return -1;
		}
	}
}

*/
