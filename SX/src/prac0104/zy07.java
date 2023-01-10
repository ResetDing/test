package prac0104;
/**
 * 
 * 方法重载练习。比较两个数据是否相等。
 * 参数类型分别为两个byte类型，两个short类型，两个int类型，两个long类型，并在main方法中进行测试。
 *
 */

public class zy07{
	
	public static void main(String[] args) {
		compare(1,2);
	}
	
	public static int compare(byte a ,byte b){
        return a<b?-1:a==b?0:1;
    }
	
	public static int compare(long a ,long b){
        return a<b?-1:a==b?0:1;
    }
	
	public static int compare(short a ,short b){
        return a<b?-1:a==b?0:1;
    }
	
}











/*
 * 

public class zy07 {
	public static void main(String[] args)
	{
		System.out.println(compare((byte)10,(byte)20));
		System.out.println(compare((short)10,(short)20));
		System.out.println(compare(10,20));
		System.out.println(compare(10L,20L));
	}
	
	//int
	public static boolean compare(int a ,int b){
        System.out.print("int ");
        return a==b;
 
    }
    //byte
    public static boolean compare(byte a ,byte b){
        System.out.print("byte ");
        return a==b;
    }
    //short
    public static boolean compare(short a ,short b){
        System.out.print("short ");
        return a==b;
    }
    //long
    public static boolean compare(long a ,long b){
        System.out.print("long ");
        return a==b;

    }
	
}


*/
