package report2;

public class optional {
	
	private int a=2,ave=0;
	inner line=new inner();
	
	
	public static class inner{                             //内部类
		
		public void show() {
			for(int i=0;i<2;i++) {
				for(int j=0;j<40;j++) {
					System.out.print("*");
				}System.out.println();
			}
		}
	
		
		public void info() {
			System.out.print("请输入您的学号姓名：");
		}
		
	}
	
	
	public int getA() {
		return a;
	}
	
	
	public void setA(int A) {
		this.a=A;                                   
			
		switch(A) {
		  case 1:A=2+2;break;
		  case 2:A=2+1;break;
		  case 3:A=2+2;break;
		  case 4:A=2+3;break;
		}
		this.a=A;
		System.out.println("您现在的学分为"+this.a+"分");
	}
	
	
	public void choice() {
		System.out.println("选修课程如下：");
		String a[]=new String[] {"课程：","美学原理","瑜伽课","乒乓球","篮球"};
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");}
		System.out.println();
	}
	
	
	public void grade() {
		String b[]=new String[] {"分数：","2","1","2","3"};
		for(int i=0;i<b.length;i++) {
			System.out.print(b[i]+"\t");}
		System.out.println();
	}
	
	
	public void Show() {
		line.show();                           
	}
	
	
	public void Info() {
		line.info();
	}
	
	
	public void history() {
		int [][]a=new int[4][4];
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=(int)(Math.random()*100);
			}
		}
		
		System.out.println("历届学生分数为：");
		
		for(int []row:a) {
			for(int each:row) {
				System.out.print(each+"\t");
			}System.out.println();
		}
		
		System.out.print("他们的平均分数为：");
		int sum=0;
		for(int []row:a) {
			for(int each:row) {
				sum+=each;
			}
		}
		ave=sum/16;
		System.out.println(ave);
		
	}

	
	public int getAve() {
		return ave;
	}

	
}
