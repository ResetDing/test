package example;
import java.util.Scanner;
public class Example {
	public static void main(String[] args) {
		System.out.println("please input a sentence:");
		Scanner Xiaoqiang=new Scanner(System.in);
		String Name1=Xiaoqiang.next();
		System.out.println("��ղ�������ǣ�"+Name1);
		System.out.println("please input a number:");
		Scanner Huahua=new Scanner(System.in);
		if(Huahua.hasNextInt()) {
			int num1=Huahua.nextInt();
			System.out.println("��ղ�������ǣ�"+num1);
			}else {
				System.out.println("�����ʽ����������һ��������");
			}
	}

}
