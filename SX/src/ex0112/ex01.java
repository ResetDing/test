package ex0112;

public class ex01 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Student.class;
		System.out.println(clazz);
		
		Student s = new Student();
		Class clazz2 = s.getClass();
		System.out.println(clazz2);
		
		String className = "ex0112.Student";
		Class clazz3 = Class.forName(className);
	}

}
