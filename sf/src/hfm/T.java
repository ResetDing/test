package hfm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class T {
	static void productFile() throws IOException {
		//97-122Ϊa-z��ascall��ֵ
		FileOutputStream out=new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\old.txt",false);
		//��������
		byte [] name= {100,105,110,103,108,105,121,117,97,110};
		out.write(name);
		byte [] n="\r\n".getBytes();
		out.write(n);
		Random r=new Random();
		//�������abcd�ȵȣ�9993��
		for(int i=0;i<9988;i++) {
			int b = r.nextInt(26)+97;
			out.write(b);
		}
		out.close();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("2018143124-������");
		productFile();
		HuffmenCodeTest h=new HuffmenCodeTest();
		//��ѹ���ļ�
	    String old = "C:\\Users\\Lenovo\\Desktop\\old.txt";
	    //ѹ���ļ�
	    String zip = "C:\\Users\\Lenovo\\Desktop\\zip.txt";
	    //��ѹ��
	    String fresh = "C:\\Users\\Lenovo\\Desktop\\new.txt";
	    HuffmenCodeTest.zipFile(old, zip);
	    try {
			h.decodeZip(zip, fresh);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}