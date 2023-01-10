package prac0104;

import java.util.Arrays;

/**
 * 
 * 打印出杨辉三角形（要求打印出 10 行）。
 *
 */

public class zy02{
	public static void main(String args[]) {
		int[] prev= {1};
		System.out.println(Arrays.toString(prev));
		for(int line=1;line<=10;line++) {
			int[] next=new int[prev.length+1];
			next[0]=1;
			for(int index=1;index<next.length-1;index++) {
				next[index]=prev[index]+prev[index-1];
			}
			next[next.length-1]=1;
			System.out.println(Arrays.toString(next));
			prev=next;
		}
	}
}











/*    方法二

public class zy02 {

	public static void main(String args[]){
        int i,j;
        int a[][];
        a=new int[10][10];
        for(i=0;i<10;i++){
          a[i][i]=1;
          a[i][0]=1;
         }
       for(i=2;i<10;i++){
        for(j=1;j<=i-1;j++){
        	a[i][j]=a[i-1][j-1]+a[i-1][j];
        	}
       } 
       for(i=0;i<10;i++){
    	   for(j=0;j<i;j++){ 
    		   System.out.printf("  "+a[i][j]);
    	   }
    	   System.out.println();
       }
    }
}

*/
