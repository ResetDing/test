package report3;

public class Testing extends Person implements jiekou {

	public Testing(int num, int age, String name) throws Exception {
		super(num, age, name);
		// TODO Auto-generated constructor stub
		if(age<18)
			throw new Exception("�����С");
		else if(age>60)
			throw new Exception("�������");  
	}

		
	
	@Override
	public double addSalary(double addSalary) throws Exception {
		// TODO Auto-generated method stub
		salary+=addSalary;
		if(salary>total) {
			throw new Exception("���ʸ��쳣");
		}else {
			return salary;
		}
	}

	@Override
	public double minusSalary(double minusSalary) throws Exception {
		// TODO Auto-generated method stub
		salary-=minusSalary;
		if(salary<basic) {
			throw new Exception("���ʵ��쳣");
		}else {
			return salary;
		}
	}

	@Override
	public void showTotalSalary(int total) throws Exception {
		// TODO Auto-generated method stub
		if(total==0) {
			throw new Exception("���쳣"); 
		}else
		{
			System.out.println("�ܼƹ���Ϊ"+salary);
		}

	}


	
	public static void main(String[] args) {
		System.out.println("ѧ�ţ�2018143124");
		System.out.println("������������");
		
		try {
			Testing a=new Testing(101,23,"����");	
			a.addSalary(8000);
		}
		catch(Exception e) {
			System.out.println("�����쳣��");
			System.out.println("ԭ��"+e.getMessage());
		}
		
		
		
		
		try {
			Testing b=new Testing(102,13,"����");		
		}
		catch(Exception e) {
			System.out.println("�����쳣��");
			System.out.println("ԭ��"+e.getMessage());
		}
		
		
		try {		
			Testing c=new Testing(103,63,"����");
		}
		catch(Exception e) {
			System.out.println("�����쳣��");
			System.out.println("ԭ��"+e.getMessage());
		}
		
	}


}
