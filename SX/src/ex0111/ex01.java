package ex0111;

import java.util.HashMap;
import java.util.Map;


public class ex01 {

	public static void main(String[] args) {
		Map map=new HashMap();
		
		map.put("张", 4);
		map.put("李", 2);
		map.put("吉", 1);
		map.put("张", 5);
		
//     	System.out.println(map);
		System.out.println(map.get("张"));
		boolean contains=map.containsKey("刘");
		System.out.println(contains);
		System.out.println(map.get("刘"));
		
		
		
		
		
		
	}

}
