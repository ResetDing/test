package shuzu;
import java.util.Arrays;
import java.util.Date;

public class shuzu {
	
	static {
		String name="丁丽媛";
		String xuehao="2018143124";
		System.out.println("姓名："+name+"\n"+"学号："+xuehao);
	}
	public static class Inner{
		public void chifan() {
			System.out.println("该吃饭了");
		}
		
	}
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("现在的时间是："+date.toString());
		Inner i=new Inner();
		i.chifan();
	}
	

}
