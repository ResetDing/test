package ex0112;

public class ex02 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String className = "ex0112.Student";
		Class clazz = Class.forName(className);
		
		Student student = (Student) clazz.newInstance();
		System.out.println(student);
		
		student.fun2();
		
	}

}