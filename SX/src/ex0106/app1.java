package ex0106;

public class app1 {
	
	public static void main(String[] args) {
		DrugDog dog=new DrugDog();
		
		DrugPig pig=new DrugPig();
		
		DrugMachine m=new DrugMachine();
		
		Police police=new Police("��Sir");   //������Police����Ĺ��췽��
		police.jidu(m);
		
	}
	
	

}
