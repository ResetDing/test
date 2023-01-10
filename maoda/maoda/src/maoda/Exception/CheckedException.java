package maoda.Exception;

import java.io.File; //输入输出文件的包
import java.io.FileWriter;
import java.io.IOException;

/**
 * 必检异常,除了RunTimeE和Error的其他类及其子类
 * @author MAOU
 *
 */
public class CheckedException
{

	public static void main(String[] args)
	{
		File file =new File("c:\test.txt");
		try
		{
			FileWriter writer=new FileWriter(file);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//文件写入器
		//判断这个文件是否存在
		System.out.println(file.exists());
	}

}
//必须要加入throw或者try catch才能找到毛病的，叫必检异常