package report2;
import java.util.Date;
import java.util.Scanner;
import report2.optional.inner;


public class choose extends optional {

	
	static {
		System.out.println("ȫУ�Թ���ѡ�޿�");
	}
	
	
	public void grade() {
		super.grade();                                          //����super�����˸���ķ���
	}
	
	
	public void choice(int x) {
	   
		String kecheng;
		
		switch(x) {
		case 1:kecheng="��ѧԭ��";System.out.println(kecheng);break;
		case 2:kecheng="�٤��";System.out.println(kecheng);break;
		case 3:kecheng="ƹ����";System.out.println(kecheng);break;
		case 4:kecheng="����";System.out.println(kecheng);break;
		
		}
	}
	
	
	public void history() {
		super.history();
	}
	
	
	public static void main(String[] args) {
		Scanner Input=new Scanner(System.in); 
		
		Date date=new Date();
		System.out.println("���ڵ�ʱ���ǣ�"+date.toString());       //����˵�ǰ��ʱ��
		
		optional Pick=new optional();                           //�����˸���Ķ���
		choose pick=new choose();                               //����������Ķ���
		
		Pick.Info();
		System.out.println();
		String num=Input.nextLine();
		
		Pick.choice();                                          //���ø����choice����������γ�
		pick.grade();                                           //��д��grade���������ѧ��
		Pick.Show();                                            //�����˸����show�����������ڲ�����������Ǻ�
		
		Pick.getA();                                            //����privateֵ
		System.out.println("��֮ǰ��ѧ��Ϊ"+Pick.getA()+"��");

		System.out.println("��ѡ������Ҫ�Ŀγ̣�");
		int x=0;
		if(Input.hasNextLine()) {
			x=Input.nextInt();
			System.out.print("��ѡ��Ŀγ�Ϊ��");
			pick.choice(x);
			Pick.setA(x);                                       //��дprivateֵ
		}
		Pick.Show();    
			
		pick.history();	
		int  z=pick.getAve();
		if(z<60) {
			System.out.println("������");
		}else {
			System.out.println("����");
		}
		
		Pick.Show();  
		Input.close();
		
		System.out.print("ѡ�ν�������������");
		
	}
	
}
