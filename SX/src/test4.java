import java.util.Scanner;
public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("请输入年份");
		int year=s.nextInt();
		if(year%4==0 && year%100!=0) {
			System.out.println(year+"是闰年");
			}else if(year%400==0) 
			{
				System.out.println(year+"是闰年");
				}else {
					System.out.println(year+"不是闰年");
					}
		}
}
