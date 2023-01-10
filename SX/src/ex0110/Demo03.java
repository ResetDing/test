package ex0110;

public class Demo03 {

	public static void main(String[] args) {
		fun();
	}
	
	public static int fun() {
		int result;
		try {
			result=10;
//			int i=1/0;
			System.out.println("try");
			return result;
		}catch(Exception e) {
			System.out.println("catch");
			return -1;
		}finally {
			result=0;
			System.out.println("ÉÆºó");
		}
	}

}
