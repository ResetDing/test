package maoda.loveletter;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NotePadDemo
{

	public static void main(String[] args)
	{
		new MyFrame2("记事本");

	}

}

//JFrame的默认布局是那个麻将桌
class MyFrame2 extends JFrame{
	private JTextArea tv_area=null;
	private JScrollPane s_pane=null;//带滚动条的面板
	private JMenuBar mb=null;//加个菜单栏
	private JMenu m_file=null;//文件菜单
	private JMenu m_help=null;//帮助菜单
	private JMenuItem item_new=null;//新建>>>文件
	private JMenuItem item_open=null;//打开>>>文件
	private JMenuItem item_exit=null;//退出>>>文件
	private JMenuItem item_about=null;//关于>>>帮助
	public MyFrame2(String title) {
		super(title);
		init();
		registerListener();
	}

	//初始化组件
	private void init(){
		tv_area=new JTextArea();//建个文本框
		s_pane=new JScrollPane(tv_area);
		s_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Container cpane =this.getContentPane();//建一个窗体
		cpane.add(s_pane,BorderLayout.CENTER);//文本框放窗体里
		this.setSize(500, 300);
		
		
		//初始化菜单
		mb=new JMenuBar();//菜单栏
		m_file=new JMenu("文件");
		item_new=new JMenuItem("新建");
		item_open=new JMenuItem("打开");
		item_exit=new JMenuItem("退出");
		m_file.add(item_new);
		m_file.add(item_open);
		m_file.add(item_exit);
		m_help=new JMenu("帮助");
		item_about=new JMenuItem("关于");
		m_help.add(item_about);
		mb.add(m_file);
		mb.add(m_help);
		//菜单栏添加到窗体中
		this.setJMenuBar(mb);
		
		
		
		
		
		
		
		
		this.setVisible(true);
		//没下面一条，就算红叉了，进程也没有结束，会有红方块
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时退出程序。
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenWidth=screenSize.width;//获得屏幕宽度
		int screenHeight=screenSize.height;
		int windowWidth=this.getWidth();//获得窗体宽度
		int windowHeight=this.getHeight();
		//居中方法如下
		this.setLocation((screenWidth-windowWidth)/2, (screenHeight-windowHeight)/2);
		
		
	}
	//初始化监听器(注册)
	private void registerListener() {
		item_new.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				newFile();
				
			}
			
		});
		
		item_open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				openFile();
				
			}
			
		});
		
		//退出功能
		item_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				exit();
				
			}
			
		});
		
		item_about.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//aboutdialog方法的三个参数，分别是所在框架，标题，和"置顶"
				new AboutDialog(MyFrame2.this, "关于记事本", false);//注意这里的true
				
			}
		});
		
		
		
		
	}
	
	//新建功能
	private void newFile() {
		if(!tv_area.getText().equals("")) {
		int res=JOptionPane.showConfirmDialog(null, "是否保存？","提示信息",
				JOptionPane.YES_NO_CANCEL_OPTION);
		//文件保存对话框
		if(res==JOptionPane.YES_OPTION) {
			FileDialog fd=new FileDialog(this,"保存文件",FileDialog.SAVE);
			fd.setVisible(true);
		}else {
			tv_area.setText("");//清空记事本的内容
		}
		
		}
	}
	//打开文件功能
	private void openFile() {
		FileDialog fd=new FileDialog(this,"打开文件",FileDialog.LOAD);
		fd.setVisible(true);

	}
	
	private void exit() {
		newFile();
		System.exit(0);

	}
	
}





class AboutDialog extends JDialog{
	private JLabel desc=null;
	private JPanel panel=null;
	private JButton btn=null;
	
	
	public AboutDialog(JFrame frame,String title,boolean model) {
		super(frame,title,model);
		init();
		registerListener();
	}



	private void init()
	{
		desc=new JLabel();
		desc.setText("beta0.1");
		desc.setHorizontalAlignment(JLabel.CENTER);//居中显示
		panel=new JPanel();
		btn=new JButton("ok");
		panel.add(btn);
		this.add(desc);//默认放在中间
		this.add(panel,BorderLayout.SOUTH);
		this.setSize(300, 300);
//		this.setVisible(true);//注册完以后再显示
	}
	
	
	
	private void registerListener()
	{	//按钮添加退出功能
		btn.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AboutDialog.this.dispose();//退出对话框
				
			}
		});
		this.setVisible(true);
	}
}



