import java.util.Scanner;

public class report {
	
	public report() {
		System.out.println();
	}
	
	public report(String goodbye) {
		System.out.println(goodbye);
	}
	
	public static void high(double x) {
		System.out.println("�������Ϊ��"+x);
	}
	
	public static void high(double x,double y) {
		double z;
		z=(x+y)/2;
		System.out.println("���ǵ�ƽ�����Ϊ��"+z);
	}
	
	public class Inner{
		public void weight() {
			Scanner input =new Scanner(System.in);
			int y=input.nextInt();
			System.out.println("��������Ϊ��"+y+"kg");
		}
	}

	public static void main(String[] args) {
		Scanner Input =new Scanner(System.in);
		report stu=new report("��������ߣ�");
		
		double x=Input.nextDouble();
		stu.high(x);
		
		System.out.println("�����������˵����");
		double m=Input.nextDouble();
		double n=Input.nextDouble();
		stu.high(m,n);
		
		System.out.println("�������������أ�");
		report.Inner i=new report().new Inner();
		i.weight();		
		
		Input.close();
	
	}
	
	
}
