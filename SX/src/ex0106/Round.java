package ex0106;
/**
 * Բ����
 * @author Lenovo
 *
 */
public class Round extends Column {
	
	/**
	 * �뾶
	 */
	private double radius;
	
	public Round() {
	}
	
	public Round(double height,double radius) {
		super(height);
		this.radius=radius;
	}
	
	public double computeArea() {
		return Math.PI*radius*radius;
	}

}
