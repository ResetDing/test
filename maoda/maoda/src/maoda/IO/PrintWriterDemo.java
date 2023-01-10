package maoda.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * PrintWriter用来处理字符流，一次写入2个字节
 * PrintStream用来处理字节流，一次写入1个字节
 * @author MAOU
 *
 */
public class PrintWriterDemo
{
	static final String FilePath="D:/tools/eclipsework/maoda/src/Demo2.java";
	public static void main(String[] args)
	{		
			String content="public static void main(String[] args)";
			content+="\t System.out.println";
		try(PrintWriter writer=new PrintWriter(new File(FilePath)) ){
			writer.write(content);
			System.out.println("写入成功");
		} catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}

		try(Scanner input =new Scanner (new File(FilePath))){
			StringBuffer value=new StringBuffer();
			while(input.hasNextLine()) {//
				value.append(input.nextLine());
				
			}
			System.out.println("从文件中读取的内容是："+value.toString());
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
