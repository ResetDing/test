package maoda;

public class Book
{
	//MVC 
	
	private String name;
	private String isbn;
	private double price;
	private int count; //库存
	private boolean borrow;//是否可借
	
	public Book() {}
	
	public Book(String name) {
		this.setName(name);
	}
	
	public Book(String name, String isbn, double price, int count) {
		setName(name);
		setIsbn(isbn);
		setPrice(price);
		setCount(count);
		setBorrow(borrow);
	}
	
	

	public  boolean isBorrow(){
		return borrow;
	}
	
	public void setBorrow(boolean borrow) {
		this.borrow = borrow;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}
	

}
