package ex0111;

import java.util.HashMap;
import java.util.Map;


public class ex01 {

	public static void main(String[] args) {
		Map map=new HashMap();
		
		map.put("��", 4);
		map.put("��", 2);
		map.put("��", 1);
		map.put("��", 5);
		
//     	System.out.println(map);
		System.out.println(map.get("��"));
		boolean contains=map.containsKey("��");
		System.out.println(contains);
		System.out.println(map.get("��"));
		
		
		
		
		
		
	}

}
