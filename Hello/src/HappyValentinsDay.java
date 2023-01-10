
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
 
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
 
 

public class HappyValentinsDay extends JFrame {
 
    private static final long serialVersionUID = 1L;
    private JLabel     label;
    private JButton    button1;
    private JButton    button2;
    private JDialog    dialog1;
 
    private int enterCount = 0;
    private boolean chooseFlag = false;
 
 
    public static final int screenWidth = 
            (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int screenHeight = 
            (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
 
 
    public HappyValentinsDay() {
//        label   = new JLabel("baby、do you love me？(*^ω^*)", SwingConstants.CENTER); // 自行修改
        label   = new JLabel("邹珂童是世界上最可爱的女孩子(*^ω^*)", SwingConstants.CENTER);
        
        
        button1 = new JButton("No(>_<｡)"); // 按钮1
        button2 = new JButton("Yes(/ω＼*)");   // 按钮2
        dialog1 = new JDialog(this);           // 创建一个新的对话框，并设置父窗口为当前窗体
        windowInitial();
        setWindowListener();
    }// constructor
 
 
    public HappyValentinsDay(String labelTxt, String bt1Txt, String bt2Txt) {
        label   = new JLabel(labelTxt, SwingConstants.CENTER);
        button1 = new JButton(bt1Txt);
        button2 = new JButton(bt2Txt);
        dialog1 = new JDialog(this);
        windowInitial();
        chooseFlag = true;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }// constructor_String
 
 
    /**
     * 窗体初始化，使用的是绝对布局
     */
    private void windowInitial() {
//        setDialog(dialog1, "Awesome!", "我也一样哦、但愿永远在一起!(*ﾟ▽ﾟ*)"); // 自行修改
        setDialog(dialog1, "Awesome!", "我也是这么认为的");
 
        label.setFont(new Font("", Font.BOLD, 17));
        label.setBounds(0, 30, 480, 20);
        
        /**
         * 以匿名内部类的方式为按钮1添加鼠标事件监听器，当鼠标进入按钮1后将突然改变自己的位置
         */
        button1.addMouseListener(new MouseListener() { 
            @Override
            public void mouseReleased(MouseEvent e) {return;}           
            @Override
            public void mousePressed(MouseEvent e) {return;}            
            @Override
            public void mouseExited(MouseEvent e) {return;}            
            @Override
            public void mouseEntered(MouseEvent e) {
                switch(enterCount) {
                case 0:
                    button1.setBounds(75, 60, 110, 30);//如果鼠标进入，则触发以下条件，并计数传递下去。
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 1:
                    button1.setBounds(75, 110, 110, 30);
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 2:
                    button1.setBounds(155, 60, 110, 30);
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 3:
                    button1.setBounds(75, 110, 110, 30);
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 4:
                    button1.setBounds(310, 110, 110, 30);//交换魔法
                    button2.setBounds(75, 110, 110, 30);
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 5:
                    button1.setBounds(75, 110, 110, 30);
                    button2.setBounds(310, 110, 110, 30);
                    HappyValentinsDay.this.repaint();
                    enterCount = 0;
                    break;
                }// seitch_entercount
            }// mouseEntered           
            @Override
            public void mouseClicked(MouseEvent e) {
                dialog1.setVisible(true);                    //显示dialog1就算你点到了不喜欢。。也是一样要喜欢我
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }// mouseClicked
        });// MouseListener
        
        button1.setBounds(70, 110, 110, 30);
        button1.setFont(new Font("", Font.BOLD, 13));
        
        /**
         * 以匿名内部类的方式为按钮2添加鼠标事件监听器，按下时显示对话框
         */
        button2.addMouseListener(new MouseListener() {      
            @Override
            public void mouseReleased(MouseEvent e) {return;}           
            @Override
            public void mousePressed(MouseEvent e) {return;}           
            @Override
            public void mouseExited(MouseEvent e) {return;}            
            @Override
            public void mouseEntered(MouseEvent e) {return;}           
            @Override
            public void mouseClicked(MouseEvent e) {
                dialog1.setVisible(true);
                chooseFlag = true;
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }// mouseClicked
        });// MouseListener
        button2.setBounds(310, 110, 110, 30);
        button2.setFont(new Font("", Font.BOLD, 13));
 
 
        Container c = getContentPane();
        c.setLayout(null);
        c.add(label);
        c.add(button1);
        c.add(button2);
        setTitle("乖 ，摸摸头！"); // 自行修改
        setBounds(screenWidth/2-250, screenHeight/2-100, 500, 200);
        setResizable(false);//不可拉伸窗体
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }// windowInitial
 
 
    /**
     * 设置对话框属性
     * @param diag
     * @param tittle
     * @param txt
     */
    private void setDialog(JDialog diag, String tittle, String txt) {
        JLabel diagLabel = new JLabel(txt, SwingConstants.CENTER);
        diagLabel.setFont(new Font("", Font.BOLD, 17));
        diagLabel.setBounds(0, 40, 430, 20);
        JButton diagBut = new JButton("嘿嘿");
        diagBut.setFont(new Font("", Font.BOLD, 14));
        diagBut.setBounds(155, 100, 100, 30);
        diagBut.addMouseListener(new MouseListener() {            
            @Override
            public void mouseReleased(MouseEvent e) {return;}                        
            @Override
            public void mousePressed(MouseEvent e) {return;}                        
            @Override
            public void mouseExited(MouseEvent e) {return;}                     
            @Override
            public void mouseEntered(MouseEvent e) {return;}          
            @Override
            public void mouseClicked(MouseEvent e) {
                diag.dispose();
                if (chooseFlag)
                    System.exit(0);
            }// mouseClicked
        });
        diag.setTitle(tittle);
        diag.setBounds(screenWidth/2-225, screenHeight/2-100, 450, 200);
        diag.setLayout(null);
        diag.add(diagBut);
        diag.add(diagLabel);
    }// setDialog
    /**
     * 设置单击窗口关闭按钮时的动作
     */
    private void setWindowListener() {
        this.addWindowListener(new WindowListener() {           
            @Override
            public void windowOpened(WindowEvent e) {return;}         
            @Override
            public void windowIconified(WindowEvent e) {return;}           
            @Override
            public void windowDeiconified(WindowEvent e) {return;}
            @Override
            public void windowDeactivated(WindowEvent e) {return;}
            @Override
            public void windowClosed(WindowEvent e) {return;}          
            @Override
            public void windowActivated(WindowEvent e) {return;}
            @Override
            public void windowClosing(WindowEvent e) {
                if(!chooseFlag) {
                    String labelTxt = "不能取消哦、再来选一回吧～"; // 自行修改
                    new HappyValentinsDay(labelTxt, "哼( ･`ω･´)", "yes");
                }// if
            }// windowClosing
        });// WindowListener
    }// setWindowListener
 
 
    public static void main(String[] args) {
        HappyValentinsDay myApp = new HappyValentinsDay();
        myApp.setVisible(true);
    }// main
 
 
}/*HappyValentinsDay*/