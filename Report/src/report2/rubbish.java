package report2;

public class rubbish {
	
	private int punish;
	
	public void fine() {
		System.out.println("��Ҫ���ķ���Ϊ��"+punish);
	}
	
	public int getPunish() {
		return punish;
	}
	
	public void setPunish(int a) {
		this.punish=a;
		this.fine();
	}
	
	public rubbish() {
		System.out.println("�����Ҷ�������Ҫ���");
	}
	
	public void learn() {
		System.out.println("����Ҫѧϰ���������֪ʶ��");
	}

}
