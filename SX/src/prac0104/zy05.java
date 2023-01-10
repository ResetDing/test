package prac0104;
import java.util.Scanner;
/**
 * 
 * 定义方法，打印给定范围之间的所有素数（质数）。
输入：范围值。
输出：素数列表。
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
	 * 判断一个数是不是素数
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
		System.out.print("请输入你要寻找素数的范围:");
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
        System.out.println("共有"+x+"个素数。");
    }
}

*/
