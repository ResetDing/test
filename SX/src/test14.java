/**
 * 
 * 给定一个年份、月份、日期，
 * 输出这是当年的第几天
 *
 */
import java.util.Scanner;
public class test14{
	
	public static void main(String[] args) {
		int year=2022;
		int month=11;
		int day=11;
		
		int[] dayNums= {31,28,31,30,31,30,31,30,31,30,28,31};
		if(year%4==0&&year%100!=0||year%400==0) {
			dayNums[1]=29;
		}
		
		int total=0;
		for(int i=0;i<month-1;i++) {
			total+=dayNums[i];
		}
		System.out.println("这是第"+(total+day)+"天");
	}

}















/**
 * 输出数组中的最小值
 * @author Lenovo
 
public class test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ages=new int[] {20,19,21,17,19,20,19,20,22};

		int min=ages[0];
		
		for(int i=1;i<ages.length;i++) {
			if(ages[i]<min) {
				min=ages[i];
			}
		}
		System.out.println(min);
		
	}

}


*
*/
