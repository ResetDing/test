import java.util.Scanner;
public class Hello1 {
	String stuName1="XiaoMing";
	public static void main(String[] args) {
		System.out.print("���������Ŀγ̣�");
		String JAVA="Java";
		String Xingshi1="����";
		String Xingshi2="ʵ��";
		Scanner Input=new Scanner(System.in);    
		if(Input.hasNextLine()) {
			if(JAVA.equals(Input.nextLine())) {
				System.out.println("������Java�Σ���Ҫȥ�ϿΣ�");
				System.out.println("����Java�ε���ʽ��");
				if(Input.hasNextLine()) {
					if(Xingshi1.equals(Input.nextLine())) {
						System.out.println("���쵽59-308�����ۿΣ�");
					}else {
						System.out.println("���쵽60-122��ʵ��Σ�");
					}
				}else {
					System.out.println("����û�Σ�ȥͼ���");
				}
				
			}
		}
	}
}
