package maoda;

public class StringBuffDemo
{

	public static void main(String[] args)
	{
		final int N=100;
		long startTime=System.currentTimeMillis();
		String str="+";
		for(int i=0;i<N;i++) {
			str +="+";
		}
		long endTime=System.currentTimeMillis();
		System.out.println("+=方法的用时"+(endTime-startTime)+"毫秒");
		
		
		
		startTime=System.currentTimeMillis();
		StringBuffer str1= new StringBuffer("+");
		for(int i=0;i<N;i++) {
			str1.append("+");
		}
		endTime=System.currentTimeMillis();
		System.out.println("buffer方法的用时"+(endTime-startTime)+"毫秒");
		
		
		
		startTime=System.currentTimeMillis();
		StringBuilder str2= new StringBuilder("+");
		for(int i=0;i<N;i++) {
			str2.append("+");
		}
		endTime=System.currentTimeMillis();
		System.out.println("builder方法的用时"+(endTime-startTime)+"毫秒");
		
		StringBuffer str3=new StringBuffer("猪是的念来过倒");
		System.out.println(str3.reverse());
		System.out.println(str3.replace(6,7,"天才"));
	    System.out.println(str3.insert(8,"猪"));
	    System.out.println(str3.deleteCharAt(8));
	    str3.setCharAt(5,'猪');
//		
//		StringBuffer strx=new StringBuffer("2上海自来水来自海上1");
//		System.out.println(strx.reverse());
		
		
//	    System.out.println(str3);
//	    System.out.println("缓存大小："+str3.capacity());
//	    str3.setLength(0);//清空缓存。
//	    str3.trimToSize();//修剪缓存不用的空间
	    
	    
//	    StringBuffer str4 =new StringBuffer("黑人问号"); 
//	    StringBuffer str5 =new StringBuffer("黑人问号");
//	    System.out.print(str4==str5);
//	    System.out.print(str4.equals(str5));
//	    System.out.print(str4.toString().equals(str5.toString()));
//	    
	}

}
