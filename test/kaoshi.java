import java.util.Arrays;
import java.util.Date;

public class kaoshi{
	
	public static void main(String[] args) {
		
		int [][]a=new int[5][5];
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=(int)(Math.random()*100);
			}
		}
		
		for(int []row:a) {
			for(int each:row) {
				System.out.print(each+"\t");
			}
			System.out.println();
		}
		
		int max=-1;
		int a_i=-1;
		int a_j=-1;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j]>max) {
					max=a[i][j];
					a_i=i;
					a_j=j;
				}
			}
		}
		
		System.out.println("找出来最大的是："+max);
		System.out.println("其坐标是"+"["+a_i+"]"+"["+a_j+"]");
		
		Date date=new Date();
		System.out.println("现在的时间："+date.toString());
	}
}

