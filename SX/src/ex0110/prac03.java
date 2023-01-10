package ex0110;

import java.util.HashSet;
import java.util.Set;

public class prac03
{

	public static void main(String[] args)
	{
		Set<Student> studentSet = new HashSet<>();
		
		Student student1 = new Student("0001","张三");
		Student student2 = new Student("0002","李四");
		Student student3 = new Student("0001","三下");
	
		//System.out.println(student1.hashCode());
		
		studentSet.add(student1);
		studentSet.add(student2);
		studentSet.add(student3);	
		System.out.println(studentSet);
	
	
	
	}
	
	
	

}