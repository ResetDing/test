package prac0104;
import java.util.Scanner;
/**
 * 
 * ���巽������ӡ������Χ֮���������������������
���룺��Χֵ��
����������б�
 *
 */

public class zy05{
	
	public static void main(String[] args) {
		findPrimes(2,100);
	}
	
	public static void findPrimes(int start,int stop) {
		for(int i=start;i<=stop;i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
	/**
	 * �ж�һ�����ǲ�������
	 */
	
	public static boolean isPrime(int num) {
		for(int i=2;i<num;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}

}















/*
 * 
public class zy05 {

	public static void main(String[] args)
	{
		System.out.print("��������ҪѰ�������ķ�Χ:");
        int number = getNumber();
        getPrimeNumber(number);
	}
	public static int getNumber(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        return i;
    }
    private static void getPrimeNumber(int number ){
        int[] arr = {};
        int i ;
        int x = 0;
        for ( i = 1 ; i <= number ; i++){
            int count = 0;
            for (int j = 1 ;j <= i; j++){
                if (i%j == 0){
                    count++;
                }
            }
            if (count == 2){
                x++;
                System.out.print(i+",");
            }
        }
        System.out.println("����"+x+"��������");
    }
}

*/
