package ex0107;

import ex0107.Person.Heart;

public class InnerDemo {

	public static void main(String[] args) {
		// 创建外部类对象
		Person p = new Person();
		// 创建内部类对象
		Heart heart = p.new Heart();

		// 调用内部类方法
		heart.jump();
		// 调用外部类方法
		p.setLive(false);
		// 调用内部类方法
		heart.jump();
		}


}
