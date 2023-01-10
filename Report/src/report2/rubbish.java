package report2;

public class rubbish {
	
	private int punish;
	
	public void fine() {
		System.out.println("需要交的罚款为："+punish);
	}
	
	public int getPunish() {
		return punish;
	}
	
	public void setPunish(int a) {
		this.punish=a;
		this.fine();
	}
	
	public rubbish() {
		System.out.println("若您乱丢垃圾就要罚款！");
	}
	
	public void learn() {
		System.out.println("您需要学习垃圾分类的知识！");
	}

}
