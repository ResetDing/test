package maoda.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo
{
	private static final String FilePath1="D:/tools/eclipsework/maoda/src/包装类&抽象类相关.zip";
	private static final String FilePath2="D:/tools/eclipsework/maoda/src/包装类&抽象类相关2.zip";
	public static void main(String[] args)
	{
		long time=CopyFileByBufferedStream();
		System.out.println("copy用时"+time+"毫秒");
	}
	private static long CopyFileByBufferedStream() {
		
		File file=new File(FilePath1);//要复制的文件
		if(!file.exists()) {System.out.println("文件不存在，不能复制");
		return 0;}
		//预备！计时！开始，复制，结束。
		long startTime =System.currentTimeMillis();
		InputStream inStream =null;
		BufferedInputStream bInStream=null;//初始内存分配
		OutputStream outStream=null;
		BufferedOutputStream bOutStream=null;
		
		try
		{
			inStream=new FileInputStream(file);
			bInStream=new BufferedInputStream(inStream);
			outStream=new FileOutputStream(FilePath2);
			bOutStream=new BufferedOutputStream(outStream);
			int i=-1;//为啥是-1？看看read
			while((i=bInStream.read())!=-1) {
				bOutStream.write(i);//逐个写入bOutStream缓存里。
			}
			System.out.println("文件复制成功");
		} catch (IOException e)//必检异常
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try
			{
				bOutStream.flush();//把缓冲中的字节转为文件
				bOutStream.close();
				bInStream.close();
				inStream.close();//注意关闭顺序
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		long endTime =System.currentTimeMillis();
		return endTime-startTime;
	}
}
