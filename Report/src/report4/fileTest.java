package report4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class fileTest {
    public static void main(String[] args) throws IOException {
        FileWriter fw1 = new FileWriter("test1.txt");     //创建FileWrite对象(覆盖写入)
        //重载一：写字符串的整体
        fw1.write("Hello,my love!");     //调用writer方法写数据
        fw1.write("\r\n");      //Windows系统中的换行方式
        fw1.write("LongRu\r\n");
        //重载二：写字符串的部分
        String str = "Hello,my love,Longru!";
        fw1.write(str,1,7);
        fw1.write("\r\n");
        //重载三：写字符数组的整体
        char[] array1 = {'H','e','l','l','o'};
        fw1.write(array1);
        fw1.write("\r\n");
        //重载四：写字符数组的部分
        char[] array2 = {'M','y',' ','l','o','v','e'};
        fw1.write(array2,3,4);
        fw1.write("\r\n");
        //重载五：写单个字符
        fw1.write(65);
        fw1.write(48);
        fw1.write("\r\n");
        fw1.close();     //调用close方法关闭流
 
        FileWriter fw2 = new FileWriter("test2.txt",true);     //创建FileWrite对象(追加写入)
        fw2.write("Hello,my love!");     //调用writer方法写数据
        fw2.write("LongRu");
        fw2.close();     //调用close方法关闭流
 
        System.out.println("==================================================");
 
        //重载一：读取单个字符
        FileReader fr1 = new FileReader("test1.txt");
        int ch;
        while ((ch = fr1.read()) != -1)
        {
            System.out.println((char) ch);
        }
        //重载二：读取指定长度字符
        FileReader fr2 = new FileReader("test2.txt");
        char[] buf = new char[2];
        int len;    //代表有效个数
        while ((len = fr2.read(buf)) != -1)
        {
            String str3 = new String(buf,0,len);
            System.out.println(str3);
        }
        fr1.close();
        fr2.close();
    }
}


