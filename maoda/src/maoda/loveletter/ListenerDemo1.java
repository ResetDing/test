package maoda.loveletter;

import java.awt.*;
import java.awt.event.*;

public class ListenerDemo1 {
    public static void main(String[] args) {
    Frame f = new Frame("TestActionEent");

    Button b1 = new Button("START"); 
    Button b2 = new Button("STOP");   //创建事件源对象b2

    Monitor2 m = new Monitor2();        //创建事件监听器m
    b1.addActionListener(m);  
    b2.addActionListener(m);         //  将事件源对象b2注册到事件监听器m中，告知b2已被m所监听
//    b2.setActionCommand("GAME OVER!");
    f.add(b1, BorderLayout.NORTH);   
    f.add(b2, BorderLayout.SOUTH);   //将按钮b2添加到面板f
    f.pack();                       //  根据内容确定Frame边框大小，类似外围包装上一层
    f.setVisible(true);
    }
}

class Monitor2 implements ActionListener {  //创建实现了事件监听接口ActionListener的事件监听器类Monitor

    public void actionPerformed(ActionEvent e) {  //  事件信息被打包在了ActionEvent e中传递过来，等待处理。
                                                  //actionPerformed()方法就是具体的处理事件的方法。 
        System.out.println("粉红色の糖掉下来了!\n" + 
        "the relative info is:" + e.getActionCommand());   //  ActionCommand中默认信息为该Button的名字
    }
}