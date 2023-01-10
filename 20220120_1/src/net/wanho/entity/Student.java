package net.wanho.entity;

public class Student {
	private String sno;
	private String sname;
	private String dname;
	private Integer sage;
	private String ssex;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", dname=" + dname + ", sage=" + sage + ", ssex=" + ssex
				+ "]";
	}
	
	
}
