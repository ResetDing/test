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
		super.learn();             //����super�������˸���ķ���
	}
	
	public void learn() {            //������д����̬
		Date date=new Date();
		System.out.println("���ڵ�ʱ���ǣ�"+date.toString());
	}

}
