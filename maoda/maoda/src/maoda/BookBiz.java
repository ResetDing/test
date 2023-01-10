package maoda;
//图书的业务类，增删改查方法
public class BookBiz
{
	//@param book要销售的图书对象
	//@return 如果销售成功，返回销售数量，失败，返回-1
	public int sellbook(Book book) {
		//1判断图书库存是否大于1
		//2图书的库存-1
		//3返回销售数量
		if(!(book.getCount()>1)) {
			return -1;
		}
		book.setCount(book.getCount()-1);
		return 1;
		
	}
}
