package maoda.loveletter;

import java.awt.*;
import java.awt.event.*;

public class ListenerDemo2 extends Frame implements WindowListener,ActionListener {
        TextField text = new TextField(20);//建立个文本框
        
        Button b;
        private int numClicks = 0;

        public static void main(String[] args) {
                ListenerDemo2 myWindow = new ListenerDemo2("My first window");//设定标题
                myWindow.setSize(350,100);
                myWindow.setVisible(true);
        }

        public ListenerDemo2(String title) {

                super(title);
                setLayout(new FlowLayout());//设定流布局
                addWindowListener(this);//右上角关闭按钮的监控
                b = new Button("Click me");//建一个按钮
                add(b);//把按钮和文本框放进窗体里
                add(text);
                b.addActionListener(this);//给按钮加上监听
        }
        //ActionListener要重写的方法
        public void actionPerformed(ActionEvent e) {
                numClicks++;//按一次就计1次数
                text.setText("Button Clicked " + numClicks + " times");
               
        }
        //WindowsListener要重写的方法，之一
        public void windowClosing(WindowEvent e) {
                dispose();//关闭窗口的监控
                System.exit(0);//关虚拟机
        }
        
        
        
      //WindowsListener要重写的方法.之2，3，4，5、、、这点很讨厌。
        public void windowOpened(WindowEvent e) {}  //强制重写的不用管它
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

}