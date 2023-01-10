package ex0111;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo03 {
/**
 * ´òÂÒÔªËØË³Ğò
 * @param args
 */
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(8);
		list.add(7);
		list.add(5);
		list.add(3);
//		Collections.shuffle(list);
//		System.out.println(list);
		
		System.out.println(list);
		Collections.sort(list);     //ÅÅĞò
		System.out.println(list);
		
		
	}

}
