package ex0112;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo03 {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\уп╡ф.jpg");
		OutputStream os = new FileOutputStream("C:\\Users\\Lenovo\\eclipse-workspace\\SX\\src\\ex0112\\уп╡ф.jpg");
		
		while (true) {
			int b = is.read();
			if (b == -1) {
				break;
			}
			os.write(b);
		}
		os.close();
		is.close();
	}

}