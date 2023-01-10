package ex0106;
/**
 * Ô²ÖùÌå
 * @author Lenovo
 *
 */
public class Round extends Column {
	
	/**
	 * °ë¾¶
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
