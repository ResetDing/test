package ex0106;
/**
 * 继承之后，构造方法的特点
 * 构造方法不能继承
 * @author Lenovo
 *
 */
public class App {

	public static void main(String[] args) {
		Car car=new Car();
		Horse h=new Horse();
		Person p=new Person();
		p.drive(car);
	}

}
