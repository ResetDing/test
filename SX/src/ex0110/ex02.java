package ex0110;

import java.util.ArrayList;
import java.util.List;

public class ex02 {

	public static void main(String[] args) {
		
		List list=new ArrayList();
		list.add("abc");
		list.add("Hello");
		list.add("world");
		list.add(123);
		
		String obj1=(String)list.get(0);
		System.out.println(obj1.length());
	}

}
