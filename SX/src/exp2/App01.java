package exp2;

public class App01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		
		Student student=new Student();
		student.setAge(20);
		student.setName("张三");
		//student.phone="110";      //封装后不可这样调用
		
		System.out.println(student.getAge());
		System.out.println(student.getName());
		//System.out.println(student.phone);
		
		student.selfIntroduce();
		
		Student stu=new Student(20,"张三","10086");
		System.out.println(stu);

	}

}
