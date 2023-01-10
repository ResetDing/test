import java.util.Random;
import java.util.ArrayList;

public class HelloWorld {
	private String stu;
	
	public static boolean isSame(int a,int b){
		boolean same=a==b;
		return same;
	}
	
	
	public static void main(String[] args) {
			System.out.println(isSame(10,10));
			
			ArrayList<Integer> list=new ArrayList<>();
			
			Random r=new Random();
			for(int i=0;i<6;i++) {
				int num=r.nextInt(33)+1;
				list.add(num);
			}
			
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i));
			}
			
			
	}
}
