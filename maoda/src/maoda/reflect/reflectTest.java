package maoda.reflect;

public class reflectTest
{

	
	    public static void main(String[] a){  
	        fruit f=factory.getInstance("maoda.reflect.Apple");  //要注意,类名地址要全
	        if(f!=null){  
	            f.eat();  
	        }  
	    }  
	}

