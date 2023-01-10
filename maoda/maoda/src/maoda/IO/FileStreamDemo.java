package maoda.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 演示文件输入输出流的基本用法
 * @author MAOU
 *
 */
public class FileStreamDemo
{
	private static final String FilePath="src/maoda/IO/FileDemo.java";
	
	public static void main(String[] args) throws IOException
	{
		File file=new File(FilePath);
		InputStream inputStream=new FileInputStream(file);//InputStream输入流是一个抽象类，所以要建子类实例化
		
				//读取文件的基本操作
				//1.建立个新的byte数组
				//2.输入流放到byte数组，然后打印出内容
		byte[] bytes=new byte[inputStream.available()+1];//获取输入流可以读取的文件大小，字节
		
	
		
		int count =0;
		while((bytes[count]=(byte)inputStream.read()) !=-1) {//读取输入流后int型转换为byte类型,读到-1跳出循环
			count ++;//读一个下一个读一个下一个
		}
		
	
			inputStream.read(bytes);//读取输入流转化为bytes第二种方法。
		
		String content =new String(bytes);//将读取的字节数组转化为字符串
		System.out.println(content);//字符串才能打印出来
		
		writeFile();

	}
	
		public static void writeFile() throws IOException
		{
			final String FilePath1="src/maoda/IO/FileDemo1.java";
			OutputStream outStream=new FileOutputStream(FilePath1,false);//是否追加写入，false就是覆盖的意思,true就是重新开档写。
			String content="public static void main(String[] args) {\n";
			content += "System.out.println(\"Hello World\");\n}";
			outStream.write(content.getBytes());//将字符串转化为字节数组，写到文件里去
			outStream.close();
		}

}
