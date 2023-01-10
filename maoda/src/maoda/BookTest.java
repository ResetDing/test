package maoda;

public class BookTest
{

	public static void main(String[] args)
	{
	   Book book =new Book("java学习","123-321",98.8,5);
	   //实例化图书业务对象
	   BookBiz bookBiz =new BookBiz();
	   bookBiz.sellbook(book);
	   
	   System.out.println(book.getCount());
	   
	}

}
