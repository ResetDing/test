package maoda.loveletter;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FocusDemo1 extends JFrame implements FocusListener
{

	private JTextField tUser, tID, tPW;

	public FocusDemo1()
	{
		JLabel User = new JLabel("用户名", JLabel.CENTER);
		JLabel ID = new JLabel("身份证号", JLabel.CENTER);
		JLabel PW = new JLabel("密码", JLabel.CENTER);
		tUser = new JTextField(10);
		tID = new JTextField(20);
		tPW = new JTextField(25);
		User.setFont(new Font("Dialog", Font.PLAIN, 20));
		ID.setFont(new Font("Dialog", Font.PLAIN, 20));
		PW.setFont(new Font("Dialog", Font.PLAIN, 20));

		setLayout(new GridLayout(3, 2));
		add(User);
		add(tUser);
		add(ID);
		add(tID);
		add(PW);
		add(tPW);

		tUser.addFocusListener(this);
		tID.addFocusListener(this);
		tPW.addFocusListener(this);

	}

	@Override
	public void focusGained(FocusEvent e)
	{
		JComponent component = (JComponent) e.getSource();
		if (component == tUser)
		{
			tUser.setText("文本框获得了焦点");
			tUser.setBackground(Color.red);
		} else if (component == tID)
		{
			tID.setText("文本框获得了焦点");
			tID.setBackground(Color.red);
		} else if (component == tPW)
		{
			tPW.setText("文本框获得了焦点");
			tPW.setBackground(Color.red);
		}

	}

	@Override
	public void focusLost(FocusEvent e)
	{
		JComponent component = (JComponent) e.getSource();
		if (component == tUser)
		{
			tUser.setText("");
			tUser.setBackground(Color.black);
		} else if (component == tID)
		{
			tID.setText("");
			tID.setBackground(Color.white);
		} else if (component == tPW)
		{
			tPW.setText("");
			tPW.setBackground(Color.yellow);
		}

	}

	public static void main(String[] args)
	{
		FocusDemo1 ft = new FocusDemo1();
		ft.pack();
		ft.setLocationRelativeTo(null);
		ft.setResizable(false);
		ft.setVisible(true);
		ft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
