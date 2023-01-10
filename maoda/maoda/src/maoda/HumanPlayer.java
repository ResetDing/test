package maoda;

public class HumanPlayer
{
	/**静态常量，用过就不能改，出拳类型的信息*/
	public static final int MessageTypeFist = 1;
	public static final int MessageTypeWin = 2;
	public static final int MessageTypeLose = 3;
//属性 名称 分数 出拳
	private String name;
	private int score;
	private int fist;
	
	/**角色出拳时说的台词*/
	private String[] fistWords = {
			"动感光波~~",
			"大象大象鼻子好长",
			"露屁屁外星人",
			"大姐姐喜欢吃青椒么",
			"胸部扁扁的欧巴桑"
	};
	private String[] winWords = {
			"还有谁~~~",
			"大象大象鼻子好长",
			"露屁屁外星人",
			"大姐姐喜欢吃青椒么",
			"胸部扁扁的欧巴桑"
	};
	
	private String[] loseWords = {
			"通往成功的路总在施工中~~",
			"233",
			"夏天就是不好",
			"大象大象鼻子好长",
			"露屁屁外星人",
			"大姐姐喜欢吃青椒么",
			"胸部扁扁的欧巴桑"
	};
/**根据消息类型，分别打印消息
 * msgType 对应HumanPlayer类中定义的静态常量*/
	public void sendMessage(int msgType) {
		//生成一个0-4之间的随机数，这逼格太高了。。
		int index =((int)(Math.random()*1000))%5;
		String message = null; //要打印的信息,先初始化分配内存
		
		
		switch(msgType) {
		case MessageTypeFist:
			message = fistWords[index];
			break;
		case MessageTypeWin:
			message = winWords[index];
			break;
		case MessageTypeLose:
			message = loseWords[index];
			break;
		}
		System.out.println(message);
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getFist()
	{
		return fist;
	}

	public void setFist(int fist)
	{
		this.fist = fist;
	}
	
	
	//方法 设置和得到名称 分数 播放音效 个性化台词 出拳
	
	
	
}
