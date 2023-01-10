package exp2;

public class App02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InternationalStudent interStudent=new InternationalStudent();
		
		interStudent.setAge(21);
		interStudent.setName("½Ü¿Ë");
		interStudent.setPhone("10000");
		
		interStudent.setEnglishName("Jack");
		
		System.out.println(interStudent.getName());
		System.out.println(interStudent.getEnglishName());
		
		interStudent.selfIntroduce();

	}

}
