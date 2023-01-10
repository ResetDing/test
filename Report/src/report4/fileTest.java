package report4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class fileTest {
    public static void main(String[] args) throws IOException {
        FileWriter fw1 = new FileWriter("test1.txt");     //����FileWrite����(����д��)
        //����һ��д�ַ���������
        fw1.write("Hello,my love!");     //����writer����д����
        fw1.write("\r\n");      //Windowsϵͳ�еĻ��з�ʽ
        fw1.write("LongRu\r\n");
        //���ض���д�ַ����Ĳ���
        String str = "Hello,my love,Longru!";
        fw1.write(str,1,7);
        fw1.write("\r\n");
        //��������д�ַ����������
        char[] array1 = {'H','e','l','l','o'};
        fw1.write(array1);
        fw1.write("\r\n");
        //�����ģ�д�ַ�����Ĳ���
        char[] array2 = {'M','y',' ','l','o','v','e'};
        fw1.write(array2,3,4);
        fw1.write("\r\n");
        //�����壺д�����ַ�
        fw1.write(65);
        fw1.write(48);
        fw1.write("\r\n");
        fw1.close();     //����close�����ر���
 
        FileWriter fw2 = new FileWriter("test2.txt",true);     //����FileWrite����(׷��д��)
        fw2.write("Hello,my love!");     //����writer����д����
        fw2.write("LongRu");
        fw2.close();     //����close�����ر���
 
        System.out.println("==================================================");
 
        //����һ����ȡ�����ַ�
        FileReader fr1 = new FileReader("test1.txt");
        int ch;
        while ((ch = fr1.read()) != -1)
        {
            System.out.println((char) ch);
        }
        //���ض�����ȡָ�������ַ�
        FileReader fr2 = new FileReader("test2.txt");
        char[] buf = new char[2];
        int len;    //������Ч����
        while ((len = fr2.read(buf)) != -1)
        {
            String str3 = new String(buf,0,len);
            System.out.println(str3);
        }
        fr1.close();
        fr2.close();
    }
}


