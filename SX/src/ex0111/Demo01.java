package ex0111;

import java.util.ArrayList;
import java.util.Collection;

public class Demo01 {

	public static void main(String[] args) {
		int a=1;
		int b=2;
		int c=3;
		int d=4;
//		Collection<Integer> col=new ArrayList<>();
		//泛型里面只可以写引用类型
//		col.add(a);
//		col.add(b);//Ctrl+Alt+下
//		col.add(c);
//		col.add(d);
		
//		int result=add(col);//静态方法直接调用
//	    System.out.println(result);
		
		int result=addAll(1,2,3,4,5);
		System.out.println(result);
		
		System.out.println(addAll(1,2));
		System.out.println(addAll());
		
	}
	
	//定义一个方法，计算两个数的和
	
	public static int add(int a,int b) {
		return a+b;
	}
	
	
	//定义一个方法，计算三个数的和
	public static int add(int a,int b,int c) {
		return a+b+c;
	}
	
	public static int add(Collection<Integer> col) {
		int result=0;
		for(Integer i:col) {
			result+=i;
		}
		return result;
	}
	
	
	//实现多个数字相加
	public static int addAll(Integer...integers) {
		int result=0;
		for(Integer i:integers) {
			result+=i;
		}
		return result;
	}

	

}
