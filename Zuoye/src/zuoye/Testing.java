package zuoye;

public class Testing {
	
	public static void main(String[] args) {
		student stu1=new student(2018143124,"丁丽媛");
		System.out.println("学号："+stu1.stuNum+" 姓名："+stu1.name);
		stu1.setJava(78);
		stu1.setDataBase(90);
		System.out.println("Java:"+stu1.getJava());
		System.out.println("DataBase:"+stu1.getDataBase());
		
	}

}

//或者stu1.set((int)(Math.random()*100),(int)(Math.random()*100));
