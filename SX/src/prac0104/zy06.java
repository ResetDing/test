package prac0104;
/**
 * 
 * ���巽��������ת��������Ϊʮ���Ƶ���ֵ��ת�����Ƶĵס�ת�����Ϊ�ַ���������9�������ô�д��ĸ���δ��档
���룺num, b
�������bΪ�׵Ľ�����
 *
 */

public class zy06{
	
	public static void main(String[] args) {
		String result=convert(5,2);        //ǰ�������֣������ǽ�����
		System.out.println(result);
	}
	
	public static String convert(int num,int base) {
		String result="";
		while(num>0) {
			int reminder=num%base;
			result=reminder+result;   //�ַ�������
			num=num/base;
		}
		return result;
	}
	
	
	
}




/*
 * 
 
public class zy06 {

	public static void main(String[] args)
	{
		System.out.println("100�Ķ������ǣ�"+Integer.toBinaryString(100));
		System.out.println("100�İ˽����ǣ�"+Integer.toOctalString(100));
		System.out.println("100��ʮ�������ǣ�"+Integer.toHexString(100));
		System.out.println("100�Ķ�ʮ�����ǣ�"+Integer.toString(100, 20));
	}

}


*/
