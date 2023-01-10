package ex0111;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo04 {
	/**
	 * 打乱元素顺序
	 * @param args
	 */

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		Student s1 = new Student(1,20,"张三");
		Student s2 = new Student(1,19,"李四");
		Student s3 = new Student(1,21,"王五");
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		System.out.println(list);
		Collections.sort(list);//变成有序的
		System.out.println(list);

	}

}