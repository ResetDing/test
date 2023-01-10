package net.wanho.entity;

import java.math.BigDecimal;

public class Customer {
	
	private Integer id;
	
	private String name;
	
	private String account;
	
	private String password;
	
	private BigDecimal balance;
	
	public Customer() {
		
	}
	
	public Customer( String name, String account, String password) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
	}
	
	public Customer(String name, String account, String password, BigDecimal balance) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.balance = balance;
	}
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
}
