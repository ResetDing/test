package ex0107;

public class App4 {

	public static void main(String[] args) {
		//创建内部类的格式
		//外部类名.内部类名 对象名=new 外部类型().new 内部类型();
		Car car=new Car();
		//Car.Engine engine=car.new Engine();
		//engine.work();
		car.move();
		car.move();

	}

}
