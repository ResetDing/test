package ex0112;

import java.lang.reflect.Field;

public class ex04 {

	public static void main(String[] args) throws Exception {
		String className = "ex0112.Student";
		Class clazz = Class.forName(className);
		
		Field[] fieldArr = clazz.getDeclaredFields();
		for (Field field : fieldArr) {
			System.out.println(field.getName());
		}
		
		Field addressField = clazz.getField("address");
		
		System.out.println(addressField.getName());
	}

}