import java.util.Scanner;

public class report {
	
	public report() {
		System.out.println();
	}
	
	public report(String goodbye) {
		System.out.println(goodbye);
	}
	
	public static void high(double x) {
		System.out.println("您的身高为："+x);
	}
	
	public static void high(double x,double y) {
		double z;
		z=(x+y)/2;
		System.out.println("你们的平均身高为："+z);
	}
	
	public class Inner{
		public void weight() {
			Scanner input =new Scanner(System.in);
			int y=input.nextInt();
			System.out.println("您的体重为："+y+"kg");
		}
	}

	public static void main(String[] args) {
		Scanner Input =new Scanner(System.in);
		report stu=new report("请输入身高：");
		
		double x=Input.nextDouble();
		stu.high(x);
		
		System.out.println("请输入两个人的身高");
		double m=Input.nextDouble();
		double n=Input.nextDouble();
		stu.high(m,n);
		
		System.out.println("请输入您的体重：");
		report.Inner i=new report().new Inner();
		i.weight();		
		
		Input.close();
	
	}
	
	
}
