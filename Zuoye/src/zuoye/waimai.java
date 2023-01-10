package zuoye;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

import javafx.scene.chart.PieChart.Data;

public class waimai {
	
	static {                                                //静态初始化块，只加载一次
		System.out.println("我是一个没有感情的自助外卖机器");
		for(int j=0;j<=1;j++) {                             //输出两行
			for(int i=0;i<=10;i++) {                        //输出11组空格和"*"
				System.out.print(" "+"*");
			}
			System.out.println();                           //输出完一行要换行
		}
	}
	
	
	public waimai() {                                       //无参构造方法块
		
		Calendar calendar= Calendar.getInstance();
    	SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
    	System.out.println("北京时间为："+dateFormat.format(calendar.getTime()));
    	System.out.println("欢迎来点餐");
	}
	
	
	public static int waimai(int x) {                       //有参有返回值构造方法块
		int price=0;
		
		switch(x) {
		case 1:price=20;break;
		case 2:price=25;break;
		case 3:price=15;break;
		case 4:price=40;break;
		}
		return price;
	}
	
	public static void menu() {                             //无参无返回值的方法
		for(int b=0;b<=37;b++) {
			System.out.print("*");
		}System.out.println();
		System.out.println("\t丁丁的店铺菜单");
	}
	
	

	
	public static void menu(String []x,String []y,String []z) {      //有参无返回值的方法重载了
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
	
	
	public class Inner {                                             //创建了一个内部类
		
		public void juzhen() {
			for(int i=0;i<4;i++) {
				System.out.print("*");
			}
		}
		
		public  void huifang() {
			System.out.println("请问本次外卖服务如何？是否需要投诉？");		
		}	
		
	}

	
	public static class call {        //静态内部类
		private String number="123456789";
		
		public  void Callfor() {
			System.out.println("投诉请拨打"+number);
		}
		
	}
	
	
	public void show(String name,String xuehao) {     //方法内部类
		
		
		  class information{
			  
				public void personl() {		
					System.out.println("用户姓名为:"+name+" ");
					System.out.println("用户学号为:"+xuehao+" ");	
					System.out.println("信息确认完毕");
				}				
			}	
		  
		  information  SHOW=new information();
		  SHOW.personl();
		}
		
	
	
	
	public static void main(String[] args) {
		Scanner Input=new Scanner(System.in);  
		waimai boss=new waimai();                           //创建外部类对象
		                                                       //创建一个Scanner对象，名为Input
		System.out.print("请输入姓名：");
		String name=Input.nextLine();  
		

		System.out.print("请输入学号：");
		String xuehao=Input.nextLine();
		System.out.println();
		
		
		boss.show(name, xuehao);
		
		System.out.println("请问是否需要点外卖？");
		System.out.println("（友情提示：需要请按1，否则按0）");
		String a="1";
    
		
		if(Input.hasNextLine()) {
			if(a.equals(Input.nextLine())) {
				waimai.menu();                              
				String []type=new String[] {"种类","1、奶茶","2、肉丝","3、蝗虫","4、榴莲"};   //创建二维数组
				String []price=new String[] {"单价","20元","25元","15元","40元"};				
				String []num=new String[] {"剩余","5","5","5","5"};
				waimai.menu(type,price,num);
			}else {
				System.out.println("再见朋友！");
			}
		}
		
	
		
		System.out.println("请选择你需要的商品？");
		int x=0;
		if(Input.hasNextLine()) {
			x=Input.nextInt();
			System.out.println("您选择的商品共"+waimai(x)+"元。");
		}
		
		
		
		Inner i=boss.new Inner();                        //创建内部类对象
		i.juzhen();                                      //调用内部类方法
		
	
		
	   System.out.println("是否领取优惠卷(是回复1 否回复0)");
	   int  money=0;
	   x=Input.nextInt();
	   if (x==1) {
		   int p=(int) (Math.random() * 5);   
		   System.out.println("获得"+p+"元优惠卷");
		   money =waimai(x)-p;
	   } 
	   else {
		 money =waimai(x);
	   }
	   
	
		
		System.out.println("选择支付方式：1、支付宝2、微信");
		int y=Input.nextInt();
		if(y==1) {
			System.out.println("支付宝到账"+money+"元");
		}
		else {
			System.out.println("微信到账"+money+"元");
		}
		System.out.println("交易成功");
		
		i.huifang();
		call C=new call();
		C.Callfor();
		
		System.out.println("五星好评，拒绝投诉");
		System.out.println("欢迎下次光临");
		Input.close();
		
    }	
}