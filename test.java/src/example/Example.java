package example;
import java.util.Scanner;
public class Example {
	public static void main(String[] args) {
		System.out.println("please input a sentence:");
		Scanner Xiaoqiang=new Scanner(System.in);
		String Name1=Xiaoqiang.next();
		System.out.println("你刚才输入的是："+Name1);
		System.out.println("please input a number:");
		Scanner Huahua=new Scanner(System.in);
		if(Huahua.hasNextInt()) {
			int num1=Huahua.nextInt();
			System.out.println("你刚才输入的是："+num1);
			}else {
				System.out.println("输入格式有误，请输入一个整数！");
			}
	}

}
