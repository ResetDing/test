import java.util.Scanner;
public class test3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("输入1次方的系数");
		int a=sc.nextInt();
		System.out.println("输入1次方的系数");
		int b=sc.nextInt();
		System.out.println("输入0次方的系数");
		int c=sc.nextInt();
		if((b*b-4*a*c)<0) {
			System.out.println("error!");
		}
		else {
			double x1=(-b+Math.sqrt(b*b-4*a*c))/2*a;
			double x2=(-b-Math.sqrt(b*b-4*a*c))/2*a;
			System.out.println("根分别是"+x1+","+x2);
		}
		
		
	}
	

}
