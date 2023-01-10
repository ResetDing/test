package maoda.IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 使用带缓存的流增加读写效率,缓存就是个字节数组
 * @author MAOU
 *
 */
public class BufferedStreamDemo
{
	static final String FilePath ="src/maoda/IO/FileDemo.java";
	public static void main(String[] args)
	{	FileInputStream fInputStream=null;//文件流分配内存
		BufferedInputStream bInputStream=null;//缓存流分配内存
		try
		{
			fInputStream=new FileInputStream(FilePath); //生成一个文件流
			bInputStream=new BufferedInputStream(fInputStream,1024);//生成一个缓存流,可以自己设定缓存
			byte[] bytes=new byte[bInputStream.available()];//字节数组的大小自己设定
					bInputStream.read(bytes);//读取缓存，放入字节数组
					System.out.println(new String(bytes));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		finally {
			
				try
				{
					bInputStream.close();//关闭缓存流
					fInputStream.close();//关闭文件流
				} catch (IOException e)
				{
					
					e.printStackTrace();
				}
			
		}

	}

}
