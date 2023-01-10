package maoda.RPG2;
/**
 * 小喵喵拆城实现
 * @author MAOU
 *
 */
public class AppMain
{

	public static void main(String[] args) throws InterruptedException
	{
		Hero hero1 = new Warrior(1,"小喵喵",0,0,150);//方法可以自己构造，比如穿了哪些装备，
		//装备附加了什么能力
		Castle castle1 = new Castle(2,"乌图姆诺",10,10);
		
		while(hero1.getHp()>0 && castle1.getHp()>0) {
		hero1.PK(castle1);
		castle1.PK(hero1);
		Thread.currentThread().sleep(1000);//多线程技术！
		}
		if(hero1.getHp()<=0) {
		System.out.print(hero1.getName()+"死了(´；ω；｀)");
		}else {
			System.out.print(hero1.getName()+"推到了"+castle1.getName());
		}
			
	}

}
