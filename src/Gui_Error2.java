import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui_Error2 implements ActionListener {
	JFrame frame;
	JLabel error;
	JButton back;
	public Gui_Error2() {//for the doctor panel
		Font f1 = new Font("Arial", Font.BOLD, 21);
		frame = new JFrame();
		frame.setBounds(280, 150, 750, 400);
		error = new JLabel("                                 Username or Password is incorrect");
		error.setFont(f1);
		error.setForeground(Color.RED);
		back = new JButton("<Back");
		back.setFont(f1);
		back.addActionListener(this);
		
		GridLayout g = new GridLayout(2,1,100,200);
		frame.setLayout(g);
		
		frame.add(error);
		frame.add(back);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			frame.setVisible(false);
			new Gui_PassDoc();
		}
		
	}
	public static void main(String[] args) {
		new Gui_Error2();
	}
	

}
