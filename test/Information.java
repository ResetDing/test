
public class Information {
	public static void main(String[] args) {
		Information Stuinfo1=new Information();
		Information.print1();
		Information Stuinfo2=new Information();
		Information.print2();
		System.out.println("����������������"+max(19,20));
		System.out.println("���ǵ��������ߵ���"+max(163,165));
		System.out.println("���Ƕ�Ϊ�人����");
		for(int i=1;i<=5;i++)//����������
			for(int j=1;j<=5;j++)//����������
				if(j%5==0)//�ڵ�����ĵط�����
					System.out.println();
				else
					System.out.print("�人���ͣ�");
		System.out.println("���и�Դ��Java��ʦ����ʵ��˿");
		
	}
	public static void print1() {
		System.out.println("2018143124��������");
	}
	public static void print2() {
		System.out.println("2018143125����Դ");
	}
	public static int max(int L1,int L2) {//ѡ��������������������
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
