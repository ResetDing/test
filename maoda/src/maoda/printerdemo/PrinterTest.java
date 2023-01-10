package maoda.printerdemo;

import maoda.printerdemo.impl.A4PaperImpl;
import maoda.printerdemo.impl.RedInkBoxImpl;

public class PrinterTest
{

	public static void main(String[] args)
	{
		Printer printer =new Printer();
		
		//打印机安装纸张和墨盒
		printer.setInkbox(new RedInkBoxImpl());
		printer.setPaper(new A4PaperImpl());
		//你要换纸张时，直接建一个纸张类型接口就行了
		//可升级可维护
		
		printer.print("小喵喵o(^･x･^)o");

	}

}
