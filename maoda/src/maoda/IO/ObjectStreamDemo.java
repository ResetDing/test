package maoda.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.omg.PortableInterceptor.ObjectIdHelper;

/**
 * 对象的序列化和反序列化操作
 * 对象必须实现serializable接口（序列化接口）
 * @author MAOU
 *
 */
public class ObjectStreamDemo
{
	private static final String FilePath ="D:/tools/eclipsework/maoda/src/save1.dat";
	public static void main(String[] args)
	{
	Player WarriorMao=new Player("小喵喵(=‘ｘ‘=)",777);
	//序列化对象写入到文件中
	try(
			FileOutputStream fOutStream =new FileOutputStream(FilePath);
			ObjectOutputStream objOutStream=new ObjectOutputStream(fOutStream)){
		objOutStream.writeObject(WarriorMao);//存档
		System.out.println("存档成功");
	} catch (FileNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try(
	FileInputStream fInStream=new FileInputStream(FilePath);
	ObjectInputStream objInStream=new ObjectInputStream(fInStream)
			){
		Player WarriorMao2=(Player)objInStream.readObject();
		System.out.println("读取的对象内容"+WarriorMao2);
		System.out.println(WarriorMao==WarriorMao2);
	} 
	
	
	
			catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e)//必检异常之，啥游戏就用啥存档
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

}

	class Player implements Serializable{
		/**
		 * 全球唯一标识
		 */
		private static final long serialVersionUID = -8986011074967593656L;
		private String nickName;
		private int level;
		
		public Player() {}
		public Player(String nickName,int level) {
			setNickName(nickName);
			setLevel(level);
		}
		
		@Override
		public String toString()
		{
			// TODO Auto-generated method stub
			return nickName+"\t"+level;
		}
		
		
		public String getNickName()
		{
			return nickName;
		}
		public void setNickName(String nickName)
		{
			this.nickName = nickName;
		}
		public int getLevel()
		{
			return level;
		}
		public void setLevel(int level)
		{
			this.level = level;
		}
		
		
		
	}
