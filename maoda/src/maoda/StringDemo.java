package maoda;

import java.util.Scanner;

/**
 * 学习一下trim的用法，和目的
 * @author MAOU
 *
 */
public class StringDemo
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
//		String uName=input.next().trim();
		String uName=input.nextLine().trim(); //nextline是string返回值，所以可以.trim,,,next()是读到空格停止
		System.out.println(uName);//看不出来，so下面加一点装饰品
		System.out.println("++"+uName+"++");

	}

}
