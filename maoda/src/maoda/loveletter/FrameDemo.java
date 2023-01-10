package maoda.loveletter;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class FrameDemo
{

	public static void main(String[] args)
	{
		MyFrame myFrame=new MyFrame("我的窗体");
		myFrame.init();
	}

}

class MyFrame extends Frame{
	public MyFrame(String title) {
		super(title);
	}
	public void init() {
		this.setSize(300, 300);
		this.setBackground(Color.pink);
		this.setLayout(null);//去掉窗体的默认布局
		Panel panel=new Panel();
		panel.setLayout(null);//去掉panel容器的默认布局
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 200, 200);
		Button btn1=new Button("clickMe");
		btn1.setBounds(0, 0, 100, 100);
		btn1.setBackground(Color.red);
		panel.add(btn1);
		
		this.add(panel);//把panel放窗体中
		this.setVisible(true);
		
	}
	
	
}