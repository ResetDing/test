package maoda.loveletter;

import java.awt.*;
import java.applet.Applet;

public class GridLayoutDemo extends Applet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9191489959922326449L;
	Button button1, button2, button3;
    public void init() {
        GridLayout layout=new GridLayout();//后面还可以加2参数，水平和高度间隙。
        this.setLayout(layout);
    	button1 = new Button("Ok");
        button2 = new Button("Open");
        button3 = new Button("Close");
        
        add(button1);
        add(button2);
        add(button3);
        this.add(new Button("111"));
        this.add(new Button("222"));
        this.add(new Button("333"));
    }
}
