package maoda.loveletter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIDemo {
    public static void main(String args[]) {
//    	Frame f = new Frame("Test"); //要关闭得写触发器关闭
    	JFrame f = new JFrame("Test"); //Frame和JFrame不一样，J开头的是swing包里的，可以算为升级版
            JButton b = new JButton("Press Me!");
            JButton bN =new JButton("北北北");
            JButton bS =new JButton("南南南");//awt包里的按键不能正常显示中文
            JButton bW =new JButton("嘻嘻嘻");
            Button bE =new Button("咚咚咚");
            Monitor bh = new Monitor();
            b.addActionListener(bh);//加监听器，监听器？就是按钮的功能。摸到这个按键会干吗。
            bN.addActionListener(bh);
            f.add(b,BorderLayout.CENTER);
            f.add(bN,BorderLayout.NORTH);
            f.add(bS,BorderLayout.SOUTH);
            f.add(bE,BorderLayout.EAST);
            f.add(bW,BorderLayout.WEST);//要注意东南西北4个控制区域不设定就不会显示的。
            f.pack();  //调整此窗口大小，以适应其组件的首先大小和布局
//          f.setSize(500,400);//只设置大小
            f.setBounds(200, 200, 500, 400);//除了设置大小外，前面还设置了初始化坐标
    		f.setLocation(300,200);
//    		f.setLayout(new FlowLayout());
            
            f.setVisible(true);//窗体默认是不可见的，要手动设置
            
    }
}

class Monitor implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("a button has been pressed");    
    }
}