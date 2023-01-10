package ex0107;

public class App5 implements MyInterface{

	public static void main(String[] args) {
		MyInterface myInterface=new MyInterface() {
			public void fun(int i) {
			}

		};
	
		MyInterface myInterface2=(int i)->{
		};
		
		MyInterface myInterface3=(j)->{
			System.out.println(j);
			System.out.println("xxxxxx");
		};
		
		MyInterface myInterface4=(j)->System.out.println(j);
		
		myInterface4.fun(8);
		

	}

	@Override
	public void fun(int i) {
		// TODO Auto-generated method stub
		
	}

	

}
