package report2;

import java.util.Date;

public class Fine extends rubbish {
	
	public static void main(String[] args){
		rubbish pay=new rubbish();
		pay.setPunish(2000);
		
		Fine Pay=new Fine();
		Pay.show();
		Pay.learn();
	}
	
	public void show() {
		super.learn();             //用了super，调用了父类的方法
	}
	
	public void learn() {            //方法重写，多态
		Date date=new Date();
		System.out.println("现在的时间是："+date.toString());
	}

}
