package ex0106;

public abstract class CompositionTemplate {
	/**
	 * 写作
	 */
	public void write() {
		System.out.println("《如何学好Java》");
		mainContent();
		System.out.println("你学会了吗？");
	}
	
	/**
	 * 写主体内容
	 */
	public abstract void mainContent();
	
	
}
