package ex0112;

import java.io.FileWriter;
import java.io.IOException;

public class Demo04 {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("src\\1.txt");//在括号里面加上,true，写的东西就不会被覆盖
		fw.write("你好，世界");
		fw.flush();
		fw.close();
	}

}