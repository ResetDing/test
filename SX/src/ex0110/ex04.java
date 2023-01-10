package ex0110;

import java.util.ArrayList;
import java.util.List;

public class ex04 {

	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("x");
		list.add("a");
		System.out.println(list.size());
		
		list.set(1,"y");
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
	}

}
