package maoda.Thread;

public class DogeTesting
{

	public static void main(String[] args)
	{
		  Doge Mission=new Doge();
		  Thread dog1=new Thread(Mission,"狗大");
		  dog1.start();
		  Thread dog2=new Thread(Mission,"狗二");
		  dog2.start();
		  Thread dog3=new Thread(Mission,"狗三");
		  dog3.start();

	}

}
