import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Gui_SearchForDoctor implements ActionListener {

	JFrame frame;
	JLabel nidl;
	JTextField NID;

	JButton submit;
	JButton cancel;

	public Gui_SearchForDoctor() {

		Font f = new Font("Arial", Font.BOLD, 21);
		Font ff = new Font("Arial", Font.PLAIN, 21);

		frame = new JFrame();
		nidl = new JLabel("                          NID");
		NID = new JTextField();
		submit = new JButton("submit");
		submit.addActionListener(this);
		cancel = new JButton("cancel");
		cancel.addActionListener(this);

		submit.setFont(f);
		cancel.setFont(f);

		frame.add(nidl);
		frame.add(NID);
		frame.add(submit);
		frame.add(cancel);
		nidl.setFont(f);
		NID.setFont(ff);

		GridLayout g = new GridLayout(2, 2);
		frame.setLayout(g);
		frame.setBounds(280, 150, 750, 400);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Search For Doctor");

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {
			String temp = NID.getText();
			int x = Integer.parseInt(temp);
			int j = 0;// flag
			for (int i = 0; i < Gui_Open.doc.length; i++) {
				if (Gui_Open.doc[i] != null) {
					if (Gui_Open.doc[i].getNid() == x) {
						j = 1;
						String nid = "" + Gui_Open.doc[i].getNid();
						String AGE = "" + Gui_Open.doc[i].getAge();
						String s = ""+Gui_Open.doc[i].getSalary();
						frame.setVisible(false);
						new View_Doctor(Gui_Open.doc[i].getName(), Gui_Open.doc[i].getGender(), nid, AGE,
								Gui_Open.doc[i].getPhone(), Gui_Open.doc[i].getEmail(),
								Gui_Open.doc[i].getAddress(), Gui_Open.doc[i].getRoom(),
								s);
						break;
					}
				}
			}
			if (j == 0) {
				frame.setVisible(false);
				new Gui_WrongSearchId();
			}
		}

		if (e.getSource() == cancel) {

			frame.setVisible(false);

		}

	}

	public static void main(String[] args) {
		new Gui_SearchForDoctor();

	}

}
