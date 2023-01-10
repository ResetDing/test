package maoda.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Date;

import javax.swing.JFileChooser;//窗体。

public class FileDemo
{

	public static void main(String[] args) throws IOException
	{
		JFileChooser fileChooser = new JFileChooser(new File("."));// 根目录

		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.showOpenDialog(null);// 显示出选择文件的对话框
		String pathName2 = fileChooser.getName();// 获得用户选择的文件
		
		File file3 = fileChooser.getSelectedFile();
		
		final String pathName = "src/maoda/IO";
		File file2 = new File(pathName);// 或者文件夹
		
		File file = new File("test.txt");// 可以是具体文件，

		System.out.println("文件或文件夹是否存在：" + file.exists());
		System.out.println("是不是一个文件：" + file.isFile());
		System.out.println("是不是一个文件夹：" + file.isDirectory());//
		System.out.println("文件名：" + file.getName());
		System.out.println("绝对路径：" + file.getAbsolutePath());
		System.out.println("路径：" + file.getPath());
		System.out.println("最后修改时间：" + new Date(file.lastModified()).toLocaleString());
		System.out.println("文件或文件夹是否存在：" + file.exists());
		System.out.println("是否隐藏：" + file.isHidden());
		System.out.println("是否可读：" + file.canRead());
		System.out.println("是否可写：" + file.canWrite());
		System.out.println("文件所占空间：" + file.length());
		System.out.println("是否可执行" + file.canExecute());

		// 使用File类创建文件
		if (!file.exists())
		{
			if (file.createNewFile())// file.mkdir()创建目录 必检异常，万一没成功
				System.out.println("文件/文件夹创建成功");
		}
		if (file.exists() && file.isFile())
		{
			// file.delete();//删除
			file.deleteOnExit();// 在程序结束时再删。。

			String[] fileNames = file2.list(new DirFilter());
			for (int i = 0; i < fileNames.length; i++)
			{// 循环打印list，列出文件名
				System.out.println(fileNames[i]);
			}

			String[] fileNames1 = file3.list(new DirFilter());
			for (int i = 0; i < fileNames1.length; i++)
			{// 循环打印list，列出文件名
				System.out.println(fileNames1[i]);
			}
					}

	}
}
