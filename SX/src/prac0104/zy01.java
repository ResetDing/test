package prac0104;
/**
 * �����꣬�£��գ�����������һ��ĵڼ��죬��������2012��1��2�գ��������ǵ�2�졣
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
		System.out.println("���ǵ�"+(total+day)+"��");
	}

}
