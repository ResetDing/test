/**
 * 
 *�Ƚ�����С���Ĵ�С
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
 * �Ƚ����������Ĵ�С��a>b����1����ȷ���0��a<b����-1
 
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
