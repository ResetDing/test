package ex0107;

import ex0107.Person.Heart;

public class InnerDemo {

	public static void main(String[] args) {
		// �����ⲿ�����
		Person p = new Person();
		// �����ڲ������
		Heart heart = p.new Heart();

		// �����ڲ��෽��
		heart.jump();
		// �����ⲿ�෽��
		p.setLive(false);
		// �����ڲ��෽��
		heart.jump();
		}


}
