package ex0107;

public class App {

	public static void main(String[] args) {
		Student student=new Student(21,"Eric");
		student.getName();
		System.out.println(Student.numberOfStudent);
		Student student2=new Student(19,"Butter");
		student.showNum();

	}

}
