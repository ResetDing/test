package ex0111;

import java.util.HashMap;
import java.util.Map;

public class ex02 {

	public static void main(String[] args) {
		Map<String,Object> studentMap=new HashMap<String,Object>();
		studentMap.put("age", 18);
		studentMap.put("name", "Jacky");
		studentMap.put("email", "10000@qq.com");
		studentMap.put("address", "常州市武进区");
		
		System.out.println(studentMap);
		studentMap.remove("address");
		System.out.println(studentMap);

		
		
		
		
	}

}
