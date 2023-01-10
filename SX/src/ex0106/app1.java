package ex0106;

public class app1 {
	
	public static void main(String[] args) {
		DrugDog dog=new DrugDog();
		
		DrugPig pig=new DrugPig();
		
		DrugMachine m=new DrugMachine();
		
		Police police=new Police("张Sir");   //调用了Police里面的构造方法
		police.jidu(m);
		
	}
	
	

}
