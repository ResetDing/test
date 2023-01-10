package ex0110;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class prac01 {

	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		
		set.add("abc");
		set.add("123");
		set.add("123");
		set.add("xyz");
		boolean c=set.contains("xyz");
		System.out.println(c);
		
		set.remove("123");
		
		System.out.println(set);
		
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("==============");
		for(String s:set) {
			System.out.println(s);
		}
		
		set.forEach((s)->System.out.println(s));
		
		
		
		
	}

}
