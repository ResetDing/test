package report2;
import java.util.Date;
import java.util.Scanner;
import report2.optional.inner;


public class choose extends optional {

	
	static {
		System.out.println("全校性公共选修课");
	}
	
	
	public void grade() {
		super.grade();                                          //用了super调用了父类的方法
	}
	
	
	public void choice(int x) {
	   
		String kecheng;
		
		switch(x) {
		case 1:kecheng="美学原理";System.out.println(kecheng);break;
		case 2:kecheng="瑜伽课";System.out.println(kecheng);break;
		case 3:kecheng="乒乓球";System.out.println(kecheng);break;
		case 4:kecheng="篮球";System.out.println(kecheng);break;
		
		}
	}
	
	
	public void history() {
		super.history();
	}
	
	
	public static void main(String[] args) {
		Scanner Input=new Scanner(System.in); 
		
		Date date=new Date();
		System.out.println("现在的时间是："+date.toString());       //输出了当前的时间
		
		optional Pick=new optional();                           //创建了父类的对象
		choose pick=new choose();                               //创建了子类的对象
		
		Pick.Info();
		System.out.println();
		String num=Input.nextLine();
		
		Pick.choice();                                          //调用父类的choice方法，输出课程
		pick.grade();                                           //重写了grade方法，输出学分
		Pick.Show();                                            //调用了父类的show方法，父类内部类输出两行星号
		
		Pick.getA();                                            //调用private值
		System.out.println("您之前的学分为"+Pick.getA()+"分");

		System.out.println("请选择您想要的课程：");
		int x=0;
		if(Input.hasNextLine()) {
			x=Input.nextInt();
			System.out.print("您选择的课程为：");
			pick.choice(x);
			Pick.setA(x);                                       //改写private值
		}
		Pick.Show();    
			
		pick.history();	
		int  z=pick.getAve();
		if(z<60) {
			System.out.println("不及格");
		}else {
			System.out.println("及格");
		}
		
		Pick.Show();  
		Input.close();
		
		System.out.print("选课结束，明年再来");
		
	}
	
}
