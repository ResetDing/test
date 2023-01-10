package maoda.Exception;

/**
 * 免检异常,父类是RunTimeException/Error
 * 
 * @author MAOU
 *
 */
public class UnCheckdException 
{
	public static void main(String[] args)
	{
//		String value =null;
//		System.out.println(value.toString());//指针为空
//		
//		String strValue="123a";
//		int value1 =Integer.parseInt(strValue);
//		System.out.println(value1);//将字符串转化为整型
//		
//		
		Person p=new Person();
		Student stu=(Student)p; //父类转化为子类时错误
			
	}

}

class Person{
	
}
class Student extends Person{
	
}