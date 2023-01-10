package maoda.IO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 1.从HTTP协议下载文件（文件流），讲文件流转到缓冲流，读取到内存里
 * 2.将缓存中的数据分块写到硬盘里（RandomAccessFile类实现）
 * 如果下一点就保存硬盘，那么硬盘读写频率很大，容易坏。
 * 所以下一段内容再保存比较好。
 * @author MAOU
 *
 */
public class Downloader_RandomAccessFile
{
	private static final String StrUrl="http://cn.download.nvidia.com/Windows/398.82/398.82-notebook-win8-win7-64bit-international-whql.exe";
	private static final int MAX_BUFFER_SIZE=102400;//缓存大小1024字节=1k，10240就是1m
	//就是说，至少下1m再写硬盘
	public static void main(String[] args)
	{
		// 1.打开http链接，获取下载内容的长度
		// 2.创建RandomAccessFile对象
		// 3.下载内容 转到字节数组，字节数组就是缓存区
		// 4.将缓存字节数组通过RandomAccessFile对象写入文件中
		HttpURLConnection connection=null;
		BufferedInputStream bInStream=null;
		try
		{
			URL url= new URL(StrUrl);//创建url对象，以便获得文件流
			 connection = (HttpURLConnection) url.openConnection();
			
			//openConnection是URLConnection的对象，
			//HttpURLConnection是URLConnection的子类对象
			//openConnection也就是HttpURLConnection的父类对象
			//所以转化为子类对象
			
			connection.setRequestProperty("Range", "bytes=0-");
			//Range指从服务器请求下载文件的大小范围，从0到最大值下载
			connection.connect();//终于连到服务器了
			//判断连接是否成功，一般成功连接的话，返回代码应该在200范围之内
			//1xx：表示请求已接受，继续操作
			//2xx:成功接受
			//3xx:重新定向
			//4xx:客户端错误
			//5xx:服务器错误
			if(connection.getResponseCode()/100!=2) {
				System.out.println("连接响应状态不在200范围内，连接错误，请重试！");
				return;
			}
			int fileSize=connection.getContentLength();//获得下载文件的大小(字节数)注意是整型
			bInStream=new BufferedInputStream (connection.getInputStream(),MAX_BUFFER_SIZE);
			//用缓冲流包装一下
			int downloaded =0;//已下载的字节数，用来计算当前下载的百分比
			String fileName=url.getFile();//获得下载的文件名
			fileName= fileName.substring(fileName.lastIndexOf("/"));
			//不这么做，获取下载名会不正常，链接最后一个/后面的文件名才是下载对象
			
			RandomAccessFile file=new RandomAccessFile(fileName,"rw");
			
			file.setLength(0);//文件清空
			file.seek(0);//将文件指针置零
			while(downloaded<fileSize) {//当前已下载的字节数小于文件总大小时，继续下载
				byte[] buffer=null;
				//判断未下载的大小是否超过最大缓存
				if(fileSize-downloaded >MAX_BUFFER_SIZE) {
					buffer=new byte[MAX_BUFFER_SIZE];
				}
				else {
					buffer=new byte[fileSize-downloaded];//下载还剩最后一点时，缓存大小也减小
				}
				int read=bInStream.read(buffer);//把缓存中的内容读出来
				if(read==-1)break;//下载完毕read没有可读的时候为-1
				
				
				//将当前下载的缓存写入到文件中
				file.seek(downloaded);//设置文件指针,每次下载的缓存块放在哪,以后可以多设几个指针，达到多线程下载
				file.write(buffer, 0, read);
				//把buffer字节数组，以read大小，从0指针开始写入
				//也可以不用后面参数
				downloaded +=read;
				System.out.println("当前下载进度："+downloaded*1.0/fileSize*10000/100+"%");
				
			}
			
			
			
			
			
		} catch (MalformedURLException e)
		{
			
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {//最后断链接，断缓冲
			connection.disconnect();
			try
			{
				bInStream.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
