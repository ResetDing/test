package ex0107;

public class Person {
	
	private boolean live = true; 
	
	class Heart {
		
		public void jump() {
		// ֱ�ӷ����ⲿ���Ա
			if (live) {
				System.out.println("����������");
				} else {
					System.out.println("���಻����");
					}
			}
		}

		public boolean isLive() { 
			return live;
		}

		public void setLive(boolean live) { 
			this.live = live;
		}




}
