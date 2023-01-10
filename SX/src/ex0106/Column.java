package ex0106;

public abstract class Column {
	
	private Double height;
	
	public Column() {
	}
	public Column(Double height) {
		this.height=height;
	}
	
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	
	public abstract double computeArea();
	
	public double computeVolume() {
		return computeArea()*this.height;
	}
	
	
}
