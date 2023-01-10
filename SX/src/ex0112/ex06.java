package ex0112;

import java.lang.reflect.Method;

public class ex06 {

	public static void main(String[] args) throws Exception {
		String className = "ex0112.Student";
		Class clazz = Class.forName(className);
			
		Method[] methodArr = clazz.getDeclaredMethods();
		for (Method method : methodArr) {
			System.out.println(method.getName());
		}
		
		Method method = clazz.getDeclaredMethod("fun", int.class);
		System.out.println(method);
	}

}