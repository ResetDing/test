package shuzu;
import java.util.Arrays;
import java.util.Date;

public class shuzu {
	
	static {
		String name="������";
		String xuehao="2018143124";
		System.out.println("������"+name+"\n"+"ѧ�ţ�"+xuehao);
	}
	public static class Inner{
		public void chifan() {
			System.out.println("�óԷ���");
		}
		
	}
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("���ڵ�ʱ���ǣ�"+date.toString());
		Inner i=new Inner();
		i.chifan();
	}
	

}
