package ex0112;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *  ‰»Î¡˜
 * @author Lenovo
 *
 */
public class Demo01 {

	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\SX\\src\\ex0112\\1.txt");
		while(true) {
			int b = is.read();
			if (b == -1) {
				break;
			}
			System.out.print((char)b);
		}
	}
}
