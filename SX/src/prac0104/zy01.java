package prac0104;
/**
 * 输入年，月，日，计算这是这一年的第几天，例如输入2012年1月2日，计算结果是第2天。
 * 
 */
public class zy01 {

	public static void main(String[] args) {
		int year=2012;
		int month=1;
		int day=2;
		
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
