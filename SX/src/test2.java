import java.util.Scanner;
public class test2 {
	//����һ��5λ�����ж����ǲ��ǻ�������
	public static void main(String[] args) {
		System.out.println("������һ��5λ����");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (9999 < num && num < 100000) {
        	int num1 = num/10000;
            int num2 = num/1000%10;
            int num3 = num/100%10;
            int num4 = num/10%10;
            int num5 = num%10;
            if(num1 == num5 && num2 == num4) {
                System.out.println(num+"�ǻ�����");
            }
            else {
                System.out.println(num+"���ǻ�������");
            }
         }else {
			System.out.println("�������������һ��5λ��");
		}
	}
	
}


