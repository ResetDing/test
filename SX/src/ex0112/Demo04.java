package ex0112;

import java.io.FileWriter;
import java.io.IOException;

public class Demo04 {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("src\\1.txt");//�������������,true��д�Ķ����Ͳ��ᱻ����
		fw.write("��ã�����");
		fw.flush();
		fw.close();
	}

}