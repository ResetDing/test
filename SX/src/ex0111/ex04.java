package ex0111;

import java.util.HashMap;
import java.util.Map;

public class ex04 {

	public static void main(String[] args) {
		//Ctrl Shift O ����
		Map<Student2,String> map=new HashMap<>();
		Student2 s1=new Student2(1,"����");
		Student2 s2=new Student2(2,"����");
		Student2 s3=new Student2(2,"����");
		
		map.put(s1, "����");
		map.put(s2, "����");
		map.put(s3, "��ݸ");
		
		System.out.println(map);
		
		
		
	}

}
