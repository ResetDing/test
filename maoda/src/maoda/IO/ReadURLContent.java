package maoda.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 读URL，暂时只支持http协议
 * @author MAOU
 *
 */
public class ReadURLContent
{

	public static void main(String[] args) throws MalformedURLException
	{
		URL url=new URL("https://www.nature.com/articles/s41586-018-0401-y");
		
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream())))
		{//以上是把输入流导入到一个缓存里，这样可以加快读取的效率
		
			String line=null;
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
		}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}


