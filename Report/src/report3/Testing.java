package report3;

public class Testing extends Person implements jiekou {

	public Testing(int num, int age, String name) throws Exception {
		super(num, age, name);
		// TODO Auto-generated constructor stub
		if(age<18)
			throw new Exception("年龄过小");
		else if(age>60)
			throw new Exception("年龄过大");  
	}

		
	
	@Override
	public double addSalary(double addSalary) throws Exception {
		// TODO Auto-generated method stub
		salary+=addSalary;
		if(salary>total) {
			throw new Exception("工资高异常");
		}else {
			return salary;
		}
	}

	@Override
	public double minusSalary(double minusSalary) throws Exception {
		// TODO Auto-generated method stub
		salary-=minusSalary;
		if(salary<basic) {
			throw new Exception("工资低异常");
		}else {
			return salary;
		}
	}

	@Override
	public void showTotalSalary(int total) throws Exception {
		// TODO Auto-generated method stub
		if(total==0) {
			throw new Exception("空异常"); 
		}else
		{
			System.out.println("总计工资为"+salary);
		}

	}


	
	public static void main(String[] args) {
		System.out.println("学号：2018143124");
		System.out.println("姓名：丁丽媛");
		
		try {
			Testing a=new Testing(101,23,"张三");	
			a.addSalary(8000);
		}
		catch(Exception e) {
			System.out.println("捕获异常！");
			System.out.println("原因："+e.getMessage());
		}
		
		
		
		
		try {
			Testing b=new Testing(102,13,"李四");		
		}
		catch(Exception e) {
			System.out.println("捕获异常！");
			System.out.println("原因："+e.getMessage());
		}
		
		
		try {		
			Testing c=new Testing(103,63,"王五");
		}
		catch(Exception e) {
			System.out.println("捕获异常！");
			System.out.println("原因："+e.getMessage());
		}
		
	}


}
