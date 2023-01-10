package maoda.RPG;

public class PKtest
{

	public static void main(String[] args)
	{
		Hero hero1 =new Warrior(1,"小喵喵",205,105);//1d 名字，坐标xy
		Hero hero2 =new Warrior(2,"深渊骑士",44,44);
		hero1.PK(hero2);
		Hero hero3 =new Ranger(3,"?黑叔叔", 666, 666);
		hero3.PK(hero2);
	}

}
