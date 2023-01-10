import java.util.Scanner;
public class Hello1 {
	String stuName1="XiaoMing";
	public static void main(String[] args) {
		System.out.print("请输入今天的课程：");
		String JAVA="Java";
		String Xingshi1="理论";
		String Xingshi2="实验";
		Scanner Input=new Scanner(System.in);    
		if(Input.hasNextLine()) {
			if(JAVA.equals(Input.nextLine())) {
				System.out.println("今天有Java课，需要去上课！");
				System.out.println("今天Java课的形式：");
				if(Input.hasNextLine()) {
					if(Xingshi1.equals(Input.nextLine())) {
						System.out.println("今天到59-308上理论课！");
					}else {
						System.out.println("今天到60-122上实验课！");
					}
				}else {
					System.out.println("今天没课，去图书馆");
				}
				
			}
		}
	}
}
