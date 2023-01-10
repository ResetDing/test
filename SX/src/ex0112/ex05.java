package ex0112;

import java.lang.reflect.Field;

public class ex05 {

	public static void main(String[] args) throws Exception {
		String className = "ex0112.Student";
		Class clazz = Class.forName(className);

		Field addressField = clazz.getField("address");
		Field nameField = clazz.getDeclaredField("name");

		Student s1 = (Student) clazz.newInstance();
		Student s2 = (Student) clazz.newInstance();
		
		addressField.set(s1, "北京东路");
		nameField.setAccessible(true);
		nameField.set(s1, "张三");
		
//		System.out.println(s1);
		
		String addressValue = (String) addressField.get(s1);
		String nameValue = (String) nameField.get(s1);
		System.out.println(addressValue);
		System.out.println(nameValue);
		
	}

}
