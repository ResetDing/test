package exp2;
/**
 * ���������ϵ��
 * ����һ�����Ρ��ࣨRect�����������ȡ�����������ԣ�����������ܳ�����������
 * �����������󣬷ֱ����ò�ͬ�ĳ����ó�������ܳ���
 * @author Lenovo
 *
 */
public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rect rect1=new Rect(5,3);
		
		int area=rect1.computeArea();
		System.out.println(area);
		int perimeter=rect1.computePerimeter();
		System.out.println(perimeter);
		
		Rect rect2=new Rect(10,4);
		rect2.computeArea();
		rect2.computePerimeter();

	}
	
	
	
}
