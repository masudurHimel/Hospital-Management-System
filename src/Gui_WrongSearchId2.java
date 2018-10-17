
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui_WrongSearchId2 implements ActionListener {
	JFrame frame;
	JLabel warning,imgL;
	JButton back, menu;
	JPanel panel;
	ImageIcon image;
	

	public Gui_WrongSearchId2() {
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.BOLD, 30);
		
		frame = new JFrame("Error");
		frame.setBounds(280, 150, 750, 400);
		frame.setForeground(Color.RED);

		warning = new JLabel("                                  Wrong Input !!");
		warning.setForeground(Color.red);
		warning.setFont(f2);

		menu = new JButton("Menu");
		menu.setFont(f1);
		menu.addActionListener(this);

		back = new JButton("<Back");
		back.setFont(f1);
		back.addActionListener(this);
		
		image = new ImageIcon("se.jpg");
		imgL = new JLabel(null, image, JLabel.CENTER);
		
		GridLayout g = new GridLayout(4, 1);
		frame.setLayout(g);
		
		frame.add(warning);
		frame.add(imgL);
		frame.add(back);
		frame.add(menu);
		

		
		
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		new Gui_WrongSearchId2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			frame.setVisible(false);
			new GUI_optionDoc();
			
			
		}
		if(e.getSource() == menu){
			frame.setVisible(false);
			new GUI_optionDoc();
			
			
		}
	}

}
