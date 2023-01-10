package tyk;

	import sun.applet.Main;

	import javax.swing.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;


	public class Main1 extends JFrame {

	    JButton button;
	    JTextArea textArea;
	    public Main1(){
	        super("文本框");
	        setSize(400,300);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        add(button = new JButton("请点击"),"North");

	        add(textArea = new JTextArea(),"Center");

	        button.addActionListener(new Adapter(textArea));

	        setVisible(true);


	    }

	    public static void main(String[] args) {
	        new Main1();
	    }

	}
	class Adapter implements ActionListener{

	    JTextArea textArea;
	    public Adapter(JTextArea textArea){
	        this.textArea = textArea;
	    }


	    @Override
	    public void actionPerformed(ActionEvent e) {
	        textArea.setText("糖掉下来了");
	    }
	}
