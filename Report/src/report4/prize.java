package report4;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class prize extends tset {
	
	public void show() {	
		ArrayList<String>A1=new ArrayList<String>();
		A1.add("37");
		A1.add("����");
		System.out.println(A1);		
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		prize zilei=new prize();
		System.out.println("����"+zilei.getName());
		System.out.println("ѧ��"+zilei.getXuehao());
		zilei.show();
		
		File f=new File("C:\\Users\\Lenovo\\Desktop\\����");
		f.mkdir();
		
		
		File f1=new File("C:\\Users\\Lenovo\\Desktop\\����\\������Ŀ.txt");
		f1.createNewFile();
		
		
		File f2=new File("C:\\Users\\Lenovo\\Desktop\\����\\�ı�.txt");
		f2.createNewFile();
		
		
		try(FileWriter write=new FileWriter(f1)){
			String txt=in.nextLine();
			char[] wenben=txt.toCharArray();
			write.write(wenben);		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		try(FileReader fr=new FileReader(f2)){
			char[] all=new char[(int)f2.length()];
			fr.read(all);
			for(char b:all) {
				System.out.println(b);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Athlete t1 = new Athlete() ;       // ʵ����Thread����� 
	    Thread A=new Thread(t1,"����һ");
	    Thread B=new Thread(t1,"���˶�");
	    A.start();
	    B.start();
	
		
	}
	

 
   
	
	
	
}
