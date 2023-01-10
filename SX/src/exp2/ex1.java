package exp2;
/**
 * 面向对象联系：
 * 定义一“矩形”类（Rect），包含长度、宽度两个属性，计算面积、周长的两个方法
 * 创建两个对象，分别设置不同的长宽，得出面积和周长。
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
