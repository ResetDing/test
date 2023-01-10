package ex0111;

import java.util.HashMap;
import java.util.Map;

public class ex04 {

	public static void main(String[] args) {
		//Ctrl Shift O 导包
		Map<Student2,String> map=new HashMap<>();
		Student2 s1=new Student2(1,"张三");
		Student2 s2=new Student2(2,"李四");
		Student2 s3=new Student2(2,"李四");
		
		map.put(s1, "北京");
		map.put(s2, "深圳");
		map.put(s3, "东莞");
		
		System.out.println(map);
		
		
		
	}

}
