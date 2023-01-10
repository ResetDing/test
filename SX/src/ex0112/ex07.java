package ex0112;

import java.lang.reflect.Method;

public class ex07 {

	public static void main(String[] args) throws Exception {
		String className = "ex0112.Student";
		Class clazz = Class.forName(className);
			
		Method[] methodArr = clazz.getDeclaredMethods();
		for (Method method : methodArr) {
			System.out.println(method.getName());
		}
		
		Method method = clazz.getDeclaredMethod("fun", int.class);
		System.out.println(method);
		
		Student s1 = (Student)clazz.newInstance();
		method.invoke(s1, 22);
		

		Method method2 = clazz.getDeclaredMethod("fun");
		method2.invoke(s1);
	}

}