package exp2;

public class Rect {
	private Integer length;
	private Integer width;
	
	public Rect() {
	}
	
	public Rect(Integer length,Integer width) {
		this.length = length;
		this.width = width;
	}
	
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	
	public int computeArea() {
		return length*width;
	}
	
	public int computePerimeter() {
		return (length+width)*2;
	}
	
	

}
