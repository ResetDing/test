
public class report2 {
	
	private static int a=90;
	
	static {
		String name="������";
		String xuehao="2018143124";
		System.out.println("������"+name+"\n"+"ѧ�ţ�"+xuehao);
		
		int []a=new int[20];
		for(int i=0;i<a.length;i++) {
			System.out.print("*");
		}System.out.println();
	}
	
	public static class inner{
		
		public void show() {
			System.out.println("��һ����ҵ�ɼ�Ϊ��"+report2.a);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		inner num =new inner();
		num.show();
	}

}
