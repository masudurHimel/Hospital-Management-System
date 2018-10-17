
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Gui_Added5forStaff implements ActionListener {
	JFrame frame;
	JLabel added, imgL;
	JButton back, menu;
	ImageIcon image;

	public Gui_Added5forStaff() {
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.BOLD, 30);

		frame = new JFrame("Successul");
		frame.setBounds(280, 150, 750, 400);
		added = new JLabel("                             Added Successfully");
		added.setFont(f2);
		back = new JButton("<Back");
		back.setFont(f1);
		back.addActionListener(this);

		menu = new JButton("Click to save & Go to the Menu");
		menu.setFont(f1);
		menu.addActionListener(this);

		image = new ImageIcon("as.jpg");
		imgL = new JLabel(null, image, JLabel.CENTER);

		GridLayout g = new GridLayout(4, 1);
		frame.setLayout(g);

		frame.add(added);
		frame.add(imgL);
		frame.add(back);
		frame.add(menu);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			frame.setVisible(false);
			new Gui_StaffSelection();
		}
		if (e.getSource() == menu) {
			try {
				Gui_Open.fstaffwrite.close();
			} catch (IOException e1) {
				System.out.println(e1);
			}
			frame.setVisible(false);
			new Gui_Selection();
		}

	}

	public static void main(String[] args) {
		new Gui_Added5forStaff();
	}

}
