package exp2;

public class App01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		
		Student student=new Student();
		student.setAge(20);
		student.setName("����");
		//student.phone="110";      //��װ�󲻿���������
		
		System.out.println(student.getAge());
		System.out.println(student.getName());
		//System.out.println(student.phone);
		
		student.selfIntroduce();
		
		Student stu=new Student(20,"����","10086");
		System.out.println(stu);

	}

}
