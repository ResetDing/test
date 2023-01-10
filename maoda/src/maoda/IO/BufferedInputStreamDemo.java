package maoda.IO;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * 代替scanner用更好的缓存流进行字符串的输入
 * @author MAOU
 *
 */
public class BufferedInputStreamDemo
{

	public static void main(String[] args) throws IOException 
	{
		System.out.println("请输入字符串：");
		BufferedInputStream inStream =new BufferedInputStream(System.in);
		byte[] bytes=new byte[200];
		inStream.read(bytes); //必检异常，必须检查是不是为空
		System.out.println("用户输入的字符串是："+new String(bytes));

	}

}
