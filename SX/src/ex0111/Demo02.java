package ex0111;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Demo02 {

	public static void main(String[] args) {
		
		Collection<String> coll=new HashSet<>();
		coll.add("Hello");
		
		Collections.addAll(coll, "abc","123","456");
		
		System.out.println(coll);
		
		String[] elements= {"a","b","c"};
		
		Collections.addAll(coll,elements);
		
		System.out.println(coll);
		
		
		
	}

}
