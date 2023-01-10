import java.util.Scanner;
public class test7 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("请输入一个三位以上的正整数：");
		
		int num=s.nextInt();
		
		while(num>0) {
			System.out.print(num%10);
			num/=10;
		}
		
		System.out.println();
		
		for(int n=1;n<=3;n++) {
			System.out.println("Hello World");
		}
		
	}

}
