import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Date;

import javax.swing.*;

public class Gui_DeleteForStaff implements ActionListener {

	JFrame frame;
	JLabel nidl;
	JTextField NID;

	JButton submit;
	JButton cancel;

	public Gui_DeleteForStaff() {

		Font f = new Font("Arial", Font.BOLD, 21);
		Font ff = new Font("Arial", Font.PLAIN, 21);

		frame = new JFrame();
		nidl = new JLabel("                          NID");
		NID = new JTextField();
		submit = new JButton("submit");
		submit.addActionListener(this);
		cancel = new JButton("cancel");
		cancel.addActionListener(this);

		frame.add(nidl);
		frame.add(NID);
		frame.add(submit);
		frame.add(cancel);
		nidl.setFont(f);
		NID.setFont(ff);

		submit.setFont(f);
		cancel.setFont(f);

		GridLayout g = new GridLayout(2, 2);
		frame.setLayout(g);
		frame.setBounds(280, 150, 750, 400);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Removal For Staff");

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {
			String temp = NID.getText();
			int x = Integer.parseInt(temp);
			int j = -1;
			int f = 0;// flag
			for (int i = 0; i < Gui_Open.staff.length; i++) {
				if (Gui_Open.staff[i] != null) {
					if (Gui_Open.staff[i].getNid() == x) {
						j = i;
						f = 1;
					}

				}
			}
			try {
				if (f == 0) {
					throw new Exception();
				}
				Gui_Open.fstaffwrite = new FileWriter("Staff.txt");
				for (int i = 0; i < Gui_Open.staff.length; i++){
					if(Gui_Open.staff[i]!=null){
						if(i!=j){
							Gui_Open.fstaffwrite.append(Gui_Open.staff[i].getName() + "\n" + Gui_Open.staff[i].getGender() + "\n" + Gui_Open.staff[i].getPosition() + "\n"
									+ Gui_Open.staff[i].getNid() + "\n" + Gui_Open.staff[i].getAge() + "\n" + Gui_Open.staff[i].getPhone() + "\n" + Gui_Open.staff[i].getEmail() + "\n"
									+ Gui_Open.staff[i].getAddress() + "\n" + Gui_Open.staff[i].getSalary() + "\n" + Gui_Open.staff[i].getJoin_date()+"\n");
						}
					}
				}
				Gui_Open.fstaffwrite.close();
				frame.setVisible(false);
				new Gui_StaffSelection();

			}

			catch (Exception ex) {
				frame.setVisible(false);
				new Gui_StaffSelection();
			}
		}

		if (e.getSource() == cancel) {

			frame.setVisible(false);

		}

	}

	public static void main(String[] args) {

		Gui_DeleteForStaff ss = new Gui_DeleteForStaff();

	}

}
