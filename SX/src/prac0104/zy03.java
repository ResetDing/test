package prac0104;
/**
 * 
 *���巽����ʵ�ֲ���������ӡ
���������巽��ʵ�ֹ��ܣ���Ҫ��������ȷ��������ֵ�Ͳ�����
��ȷ����ֵ�������д�ӡ��HelloWorld���ɣ�û�м�����������ֵ����	��
��ȷ��������ӡ���β��������������һ�����Ͳ���
 *
 */



public class zy03 {

	public static void main(String[] args)
	{
		printHelloWorld(10);          //���÷���printHelloWorld���������� 
	}
	
	public static void printHelloWorld() { //���أ������뼸�ξ����5��
		printHelloWorld(5); 
	}
	
		
	//�����ӡHelloWorld���� ����ֵ���ͣ�����û�н�� void ��������ȷ����ӡ���� 
	public static void printHelloWorld(int n) { 
		for (int i = 0; i < n; i++) { 
			System.out.println("HelloWorld"); 
		}
	}

}
