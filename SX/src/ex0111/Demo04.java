package ex0111;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo04 {
	/**
	 * ����Ԫ��˳��
	 * @param args
	 */

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		Student s1 = new Student(1,20,"����");
		Student s2 = new Student(1,19,"����");
		Student s3 = new Student(1,21,"����");
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		System.out.println(list);
		Collections.sort(list);//��������
		System.out.println(list);

	}

}