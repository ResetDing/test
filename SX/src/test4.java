import java.util.Scanner;
public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("���������");
		int year=s.nextInt();
		if(year%4==0 && year%100!=0) {
			System.out.println(year+"������");
			}else if(year%400==0) 
			{
				System.out.println(year+"������");
				}else {
					System.out.println(year+"��������");
					}
		}
}