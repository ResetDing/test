package zuoye;

public class Testing {
	
	public static void main(String[] args) {
		student stu1=new student(2018143124,"������");
		System.out.println("ѧ�ţ�"+stu1.stuNum+" ������"+stu1.name);
		stu1.setJava(78);
		stu1.setDataBase(90);
		System.out.println("Java:"+stu1.getJava());
		System.out.println("DataBase:"+stu1.getDataBase());
		
	}

}

//����stu1.set((int)(Math.random()*100),(int)(Math.random()*100));
