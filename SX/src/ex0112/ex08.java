package ex0112;

import java.lang.reflect.Constructor;

public class ex08{

	public static void main(String[] args) throws Exception {
		String className = "ex0112.Student";
		Class clazz = Class.forName(className);
		
		Constructor[] constructorArr = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructorArr) {
//			System.out.println(constructor);
		}
		
		Constructor con = clazz.getDeclaredConstructor(Integer.class, String.class);
		System.out.println(con);
		
		Student  s = (Student) con.newInstance(20, "уехЩ");
		
	}

}
