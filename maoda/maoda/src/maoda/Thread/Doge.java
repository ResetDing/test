package maoda.Thread;

public class Doge implements Runnable
{

	private int coinsInAll = 1000;
	int effect;
	int sum = 0;

	@Override
	public void run()
	{
		while (true)
		{

			synchronized (Doge.class)
			{
				effect = (int) (Math.random() * 9+1);
				if ((sum + effect) <= 1000)
				{

					sum += effect;
					coinsInAll=coinsInAll-effect;
					System.out.println(
							Thread.currentThread().getName() + "一凿子下去挖了" + effect + "枚金币" + "当前已经总共挖了" + sum + "枚金币");
					System.out.println("猫大家的矿山还有"+coinsInAll+"金币");
					try
					{
						Thread.sleep(100);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
//				else
//				{	
//					System.out.println(Thread.currentThread().getName()+"最后一次挖出" + (coinsInAll - sum) + "金币");
//				
//					break;
//				}
				
			}

		}
	}
}
