/**
 * 
 * ����һ�������������1��n�ĺͣ���������
 * n�������1������
 *
 */
public class test11 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=100;
		int a=sum(x,false);
		System.out.println(a);

	}
	
	public static int sum(int n,boolean containsEnd) {
		int result=0;
		if(containsEnd) {
			n++;
		}
		for(int i=1;i<n;i++) {
			result+=i;
		}
		return result;
	}

}
