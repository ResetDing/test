package maoda.printerdemo;

/**
 * 打印机类，使用标准墨盒和纸张进行打印
 * @author MAOU
 *
 */
import maoda.printerdemo.iface.*;

public class Printer
{
	private IInkBox inkbox = null; // 打印机中的墨盒
	private IPaper paper = null; // 打印机中的纸张,默认为空
	// 以前是面向对象编程，要定义对象首先要定义类
		// 现在是面向接口编程，要实现某个功能先定义接口
	
	public void print(String content) {//传进打印机要打的内容
	if (null==inkbox||null==paper)
	{
		System.out.println("墨盒和纸张出现错误，请安装正确后重试");
		return;
	}
		//打印过程以下
		String color =inkbox.getColor();
		String type =paper.getSize();
		System.out.println("打印颜色为："+color);
		System.out.println("使用纸张为："+type);
		System.out.println("打印内容为："+content);
	}
	
	
	public IInkBox getInkbox()
	{
		return inkbox;
	}

	public void setInkbox(IInkBox inkbox)
	{
		this.inkbox = inkbox;
	}

	public IPaper getPaper()
	{
		return paper;
	}

	public void setPaper(IPaper paper)
	{
		this.paper = paper;
	}
	// 生成get set
	

}
