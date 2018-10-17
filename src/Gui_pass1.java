import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Gui_pass1 implements ActionListener {

	JFrame frame;
	JLabel userL, passL;
	JTextField user;
	JPasswordField pass;
	JButton submit, cancel;

	public Gui_pass1() {// admin's login
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.PLAIN, 21);

		frame = new JFrame();
		frame.setBounds(280, 150, 750, 400);

		GridLayout g = new GridLayout(3, 2);
		frame.setLayout(g);

		userL = new JLabel("                 User ID");
		userL.setFont(f1);
		passL = new JLabel("                 Password");
		passL.setFont(f1);

		user = new JTextField();
		user.setFont(f2);
		pass = new JPasswordField();
		pass.setFont(f2);

		submit = new JButton("Submit");
		submit.setFont(f1);
		cancel = new JButton("Cancel");
		cancel.setFont(f1);

		frame.add(userL);
		frame.add(user);
		frame.add(passL);
		frame.add(pass);
		frame.add(submit);
		submit.addActionListener(this);
		frame.add(cancel);
		cancel.addActionListener(this);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Admin's Login");

	}

	public static void main(String[] args) {
		new Gui_pass1();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			if (pass.getText().equals(new Settings().getUsername()) && user.getText().equals(new Settings().getPwdu())) {
				frame.setVisible(false);
				new Gui_Selection();
			} else {
				frame.setVisible(false);
				new Gui_Error1();
			}

		}
		if (e.getSource() == cancel) {
			frame.setVisible(false);

		}
	}

}
