package maoda;

import java.util.Scanner;

public class BoxingDemo
{

	public static void main(String[] args)
	{
			double num1 =3.14;
			Double dnum1=new Double("3.14"); //装箱相当于把数值num1包装成了1个对象
//			short b = dnum1.shortValue();     //很多用法可以查javaAPI攻略
			
			Math.abs(dnum1);//没有matlab强
			
			int a=200;
			int b=200;
			System.out.println("a和b是否相等："+(a==b));
			
//			System.out.println(dnum1.equals(num1)); //比较2值是否相等
//			
//			System.out.println(dnum1.toHexString(dnum1));//返回 double参数的十六进制字符串 double形式
//			
//			num1 =dnum1;  //拆箱
//			
			Integer num2 =100;
			Integer num3 =100;
			System.out.println("num2和num3是否相等"+(num2 == num3));//指针
//			
			Integer num4 =200;							//Integer num4 =200;等价于Integer num4 =Integer.valueOf(200);
			Integer num5 =200;
			System.out.println("num4和num5是否相等"+(num4 == num5));
			Integer num6 =Integer.valueOf(200);
//														//包装类的num4和num5是2个对象，而不是简单的值，所以
																						//分配的内存地址也不一样，“==”的功能是进行地址匹配。所以false。
			//判断用户输入的字符串是不是纯数字
//			Character.isDigit(char ch);//判断1个字符是不是一个数字
			
			
//			boolean isDigit=true; 
//			System.out.println("输入一个字符串，我来判断是不是一个纯数字");
//			String value=new Scanner(System.in).next();
//			for(int i=0;i < value.length();i++) {
//				if(!Character.isDigit(value.charAt(i))) {  //charAt(i)在字符数组的第i个字符。
//					isDigit=false ;
//					break;
//				}
//			}
//			if(!isDigit) {
//				System.out.println("不是一个数字");
//			}
//			else {
//				System.out.println("是一个数字");
//			}
//			
//			
			String value2="晚上我想吃: ";//字符串一旦创建，在内存里是不可更改的
			String value3="晚上我想吃: ";//只是指针是可以改的
			System.out.println("value2的打印值是："+value2);
			System.out.println("value3的打印值是："+value3);
			System.out.println("value2和value3是否相等？"+(value2==value3));//如果内容相同，会放进字符串池。同地址
//			
//			value2.equals(value3);
//			
            value2.concat("炸鸡+可乐");//拼接时候已经创建新的string到字符串池子里去了
            System.out.println(value2);
////            
            value2=value2.concat("炸鸡+可乐");
            System.out.println(value2);//value2赋值上面池子里的“炸鸡+可乐”看看concat的源码
            String value4="晚上我想吃: "+"炸鸡+可乐";
            System.out.println("value2的打印值是："+value2);
            System.out.println("value4的打印值是："+value4);
            System.out.println("value2和value4是否相等？"+(value2==value4));
//            
			
			String value5="大吉大利，晚上吃鸡";
			String value6="大吉大利，晚上吃鸡";
			String value7=new String ("大吉大利，晚上吃鸡");
			String value8=new String ("大吉大利，晚上吃鸡");
			System.out.println("value5和value6是否相等？"+(value5==value6));
			System.out.println("value5和value7是否相等？"+(value5==value7));
			System.out.println("value7和value8是否相等？"+(value7==value8));
			
			
	}

}
