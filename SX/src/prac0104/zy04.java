package prac0104;
/**
 * 
 *���巽��������1+2+3...+100�ĺ͡�
���������巽��ʵ�ֹ��ܣ���Ҫ��������ȷ��������ֵ�Ͳ�����
��ȷ����ֵ��1~100����ͣ�������Ȼ��������������ֵ������int 
��ȷ��������������֪����������ݣ�û��δ֪�����ݣ����������
 *
 */
public class zy04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=sum();
		System.out.println("1~100�ĺ���"+a);

	}
	
	public static int sum() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			sum+=i;
		}
		return sum;
	}

}
