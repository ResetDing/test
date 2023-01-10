
public class Information {
	public static void main(String[] args) {
		Information Stuinfo1=new Information();
		Information.print1();
		Information Stuinfo2=new Information();
		Information.print2();
		System.out.println("他们中年龄最大的是"+max(19,20));
		System.out.println("他们当中身高最高的是"+max(163,165));
		System.out.println("他们都为武汉加油");
		for(int i=1;i<=5;i++)//方阵有五行
			for(int j=1;j<=5;j++)//方阵有四列
				if(j%5==0)//在第五个的地方换行
					System.out.println();
				else
					System.out.print("武汉加油！");
		System.out.println("其中高源是Java老师的忠实粉丝");
		
	}
	public static void print1() {
		System.out.println("2018143124，丁丽媛");
	}
	public static void print2() {
		System.out.println("2018143125，高源");
	}
	public static int max(int L1,int L2) {//选择两个数字中最大的数字
		if(L1>=L2)
			return L1;
		else
			return L2;
	}
	public static double max(double H1,double H2) {
		if(H1>=H2)
			return H1;
		else
			return H2;
	}
}
