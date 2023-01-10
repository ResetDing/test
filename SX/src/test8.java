import java.util.Scanner;

public class test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double distance=0;
		double bounce=0;
		double height=100;
		
		int n=2;
		for(int i=1;i<=n;i++) {
			distance+=height;
			bounce=height/2;
			if(i==n) {
				break;
			}
			distance+=bounce;
			height=bounce;
		}
		System.out.println(distance);
		System.out.println(bounce);
		
	}

}
