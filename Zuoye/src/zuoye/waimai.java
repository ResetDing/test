package zuoye;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

import javafx.scene.chart.PieChart.Data;

public class waimai {
	
	static {                                                //��̬��ʼ���飬ֻ����һ��
		System.out.println("����һ��û�и����������������");
		for(int j=0;j<=1;j++) {                             //�������
			for(int i=0;i<=10;i++) {                        //���11��ո��"*"
				System.out.print(" "+"*");
			}
			System.out.println();                           //�����һ��Ҫ����
		}
	}
	
	
	public waimai() {                                       //�޲ι��췽����
		
		Calendar calendar= Calendar.getInstance();
    	SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
    	System.out.println("����ʱ��Ϊ��"+dateFormat.format(calendar.getTime()));
    	System.out.println("��ӭ�����");
	}
	
	
	public static int waimai(int x) {                       //�в��з���ֵ���췽����
		int price=0;
		
		switch(x) {
		case 1:price=20;break;
		case 2:price=25;break;
		case 3:price=15;break;
		case 4:price=40;break;
		}
		return price;
	}
	
	public static void menu() {                             //�޲��޷���ֵ�ķ���
		for(int b=0;b<=37;b++) {
			System.out.print("*");
		}System.out.println();
		System.out.println("\t�����ĵ��̲˵�");
	}
	
	

	
	public static void menu(String []x,String []y,String []z) {      //�в��޷���ֵ�ķ���������
		for(int i=0;i<x.length;i++) {
			System.out.print(x[i]+"\t");}
		System.out.println();
		
		for(int i=0;i<y.length;i++) {
			System.out.print(y[i]+"\t");}
		System.out.println();
		
		for(int i=0;i<z.length;i++) {
			System.out.print(z[i]+"\t");}
		System.out.println();
		
		for(int b=0;b<=37;b++) {
			System.out.print("*");
		}System.out.println();
    }
	
	
	public class Inner {                                             //������һ���ڲ���
		
		public void juzhen() {
			for(int i=0;i<4;i++) {
				System.out.print("*");
			}
		}
		
		public  void huifang() {
			System.out.println("���ʱ�������������Σ��Ƿ���ҪͶ�ߣ�");		
		}	
		
	}

	
	public static class call {        //��̬�ڲ���
		private String number="123456789";
		
		public  void Callfor() {
			System.out.println("Ͷ���벦��"+number);
		}
		
	}
	
	
	public void show(String name,String xuehao) {     //�����ڲ���
		
		
		  class information{
			  
				public void personl() {		
					System.out.println("�û�����Ϊ:"+name+" ");
					System.out.println("�û�ѧ��Ϊ:"+xuehao+" ");	
					System.out.println("��Ϣȷ�����");
				}				
			}	
		  
		  information  SHOW=new information();
		  SHOW.personl();
		}
		
	
	
	
	public static void main(String[] args) {
		Scanner Input=new Scanner(System.in);  
		waimai boss=new waimai();                           //�����ⲿ�����
		                                                       //����һ��Scanner������ΪInput
		System.out.print("������������");
		String name=Input.nextLine();  
		

		System.out.print("������ѧ�ţ�");
		String xuehao=Input.nextLine();
		System.out.println();
		
		
		boss.show(name, xuehao);
		
		System.out.println("�����Ƿ���Ҫ��������");
		System.out.println("��������ʾ����Ҫ�밴1������0��");
		String a="1";
    
		
		if(Input.hasNextLine()) {
			if(a.equals(Input.nextLine())) {
				waimai.menu();                              
				String []type=new String[] {"����","1���̲�","2����˿","3���ȳ�","4������"};   //������ά����
				String []price=new String[] {"����","20Ԫ","25Ԫ","15Ԫ","40Ԫ"};				
				String []num=new String[] {"ʣ��","5","5","5","5"};
				waimai.menu(type,price,num);
			}else {
				System.out.println("�ټ����ѣ�");
			}
		}
		
	
		
		System.out.println("��ѡ������Ҫ����Ʒ��");
		int x=0;
		if(Input.hasNextLine()) {
			x=Input.nextInt();
			System.out.println("��ѡ�����Ʒ��"+waimai(x)+"Ԫ��");
		}
		
		
		
		Inner i=boss.new Inner();                        //�����ڲ������
		i.juzhen();                                      //�����ڲ��෽��
		
	
		
	   System.out.println("�Ƿ���ȡ�Żݾ�(�ǻظ�1 ��ظ�0)");
	   int  money=0;
	   x=Input.nextInt();
	   if (x==1) {
		   int p=(int) (Math.random() * 5);   
		   System.out.println("���"+p+"Ԫ�Żݾ�");
		   money =waimai(x)-p;
	   } 
	   else {
		 money =waimai(x);
	   }
	   
	
		
		System.out.println("ѡ��֧����ʽ��1��֧����2��΢��");
		int y=Input.nextInt();
		if(y==1) {
			System.out.println("֧��������"+money+"Ԫ");
		}
		else {
			System.out.println("΢�ŵ���"+money+"Ԫ");
		}
		System.out.println("���׳ɹ�");
		
		i.huifang();
		call C=new call();
		C.Callfor();
		
		System.out.println("���Ǻ������ܾ�Ͷ��");
		System.out.println("��ӭ�´ι���");
		Input.close();
		
    }	
}