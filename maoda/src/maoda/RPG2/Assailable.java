package maoda.RPG2;
/**
 * 可[被]攻击接口
 * @author MAOU
 *
 */
public interface Assailable
{
	String getName(); //谁打了你
	int getX();//
	void setX(int x);
	int getY();
	void setY(int y);
	int getHp();
	void setHp(int hp);
	boolean canFightByDistance(Assailable assa);//根据距离判断，是否能攻击另一个具备攻击能力的对象

	void fight(Assailable assa);//攻击另一个具备攻击能力的对象

}
