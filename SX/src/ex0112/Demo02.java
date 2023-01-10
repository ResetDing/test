package ex0112;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo02 {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("src\\ex0112\\2.txt", true);//添加true则不会覆盖之前的内容
		for (int i = 'A'; i <= 'Z'; i++) {
			os.write(i);
		}
		os.close();
	}

}
