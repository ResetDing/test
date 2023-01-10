import java.util.Scanner;
public class Hello {
	String stuName1="Xiaoming";
	public static void main(String[] args) {
		String stuName="XiaoMing";
		int stuNum=123456;
		boolean java=false;
		int Xingshi=1;
		System.out.println(stuName);
		System.out.println(stuNum);
		if(java) {
			System.out.println("今天有课，去上课");
			if(Xingshi==1) {
				System.out.println("理论课，59-308");
			}else {
				System.out.println("不是理论课，60-122");
			}
		}else {
			System.out.println("今天没课，去图书馆");
		}
	}

}
