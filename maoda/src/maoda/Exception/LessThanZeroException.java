package maoda.Exception;
/**
 * 自定义异常
 * @author MAOU
 *
 */
public class LessThanZeroException extends Exception
{
	//重写父类的2个构造方法就行
	
	public LessThanZeroException() {
		super("不能小于0");
	}
	public LessThanZeroException(int value) {
		super("输入的数值："+value+ " 不能小于0");
}
}