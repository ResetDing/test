
public class report1 {
	
	private static int a=90;
	
	static {
		String name="丁丽媛";
		String xuehao="2018143124";
		System.out.println("姓名："+name+"\n"+"学号："+xuehao);
		
		int []a=new int[20];
		for(int i=0;i<a.length;i++) {
			System.out.print("*");
		}System.out.println();
	}
	
	public static class inner{
		
		public void show() {
			System.out.println("第一次作业成绩为："+report1.a);
		}
		
	}
	
	public void Show() {
		int a=95;
		System.out.println("第二次作业成绩为："+a);
	}
	
	public static void main(String[] args) {
		
		inner num =new inner();
		num.show();
		
		report1 num1=new report1();
		num1.Show();
		
	}

}
