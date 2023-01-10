package ex0110;

import java.util.Arrays;

public class ex01 {

	public static void main(String[] args) {
		/*
		int[] arr=new int[5];
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		arr[3]=3;
		arr[4]=4;
		*/
		//向arr数组中添加第6个元素“5”
		int[] arr=new int[] {1,2,3,4,5};
		
		int[] newArr=new int[arr.length+1];
		
		for(int i=0;i<arr.length;i++) {
			newArr[i]=arr[i];
			}
		
		newArr[newArr.length-1]=6;
		
		arr=newArr;
		
		System.out.println(Arrays.toString(arr));
		
	}

}
