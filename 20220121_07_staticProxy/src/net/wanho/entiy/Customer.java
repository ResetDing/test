package net.wanho.entiy;

public class Customer {

	private Integer id;
	private String name;
	private String acccount;
	private String password;
	private Double balance; // java.math.BigDecimal
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcccount() {
		return acccount;
	}
	public void setAcccount(String acccount) {
		this.acccount = acccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
}
