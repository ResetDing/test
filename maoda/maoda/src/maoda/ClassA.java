package maoda;
/**
 * 静态是什么机制
 * @author MAOU
 *
 */
class ClassA
{
	int b;

	public void ex1()
	{
	System.out.println("777");
	}
}

class ClassB
{
	void ex2(){ 
		int i; 
		ClassA a = new ClassA(); //实例化classA后才能引用b
		i = a.b; 				//这里通过对象引用访问成员变量b 
		a.ex1(); 				//这里通过对象引用访问成员函数ex1 
}
}

// 声明为static

class ClassC
{
	static int c;

	static void ex1()
	{

	}
}

class ClassD
{
	void ex2(){ 
		int i; 				//不用实例化Class C都能引用c，说明c是一个全局变量，
							// 只要程序运行，初始化就分配内存了
		i = ClassC.c; 		//这里通过类名访问成员变量c 
		ClassC.ex1(); 		//这里通过类名访问成员函数ex1 静态变量不需要实例化就能引用成员
}
}