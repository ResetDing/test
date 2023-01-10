package ex0111;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo05 {
	/**
	 * 自定义类型排序
	 * @param args
	 */

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		Student s1 = new Student(10,20,"张三");
		Student s2 = new Student(2,20,"李四");
		Student s3 = new Student(3,21,"王五");
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		System.out.println(list);
		Comparator<Student> comparator = new Comparator<Student>() {

			@Override
			public int compare(Student arg0, Student arg1) {
				return 0;
			}
			
		};
		Collections.sort(list,(o1,o2) ->{
			return o2.getAge() - o1.getAge();
		});
		System.out.println(list);
		
		Collections.sort(list,(o1,o2) ->{
			int result = o2.getAge() - o1.getAge();
			if(result == 0) {
				result = o1.getId() - o2.getId();
			}
			return result;
		});
		System.out.println(list);
	}

}
