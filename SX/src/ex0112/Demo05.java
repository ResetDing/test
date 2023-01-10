package ex0112;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo05{

	public static void main(String[] args) throws IOException {
		File file = new File("src\\1.txt");
		FileReader fr = new FileReader(file);
		char[] arr = new char[50];
		fr.read(arr);
		for(char c : arr) {
			System.out.print(c);
		}
	}
}