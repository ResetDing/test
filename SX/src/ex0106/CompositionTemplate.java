package ex0106;

public abstract class CompositionTemplate {
	/**
	 * д��
	 */
	public void write() {
		System.out.println("�����ѧ��Java��");
		mainContent();
		System.out.println("��ѧ������");
	}
	
	/**
	 * д��������
	 */
	public abstract void mainContent();
	
	
}
