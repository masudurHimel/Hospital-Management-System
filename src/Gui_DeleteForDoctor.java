import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Date;

import javax.swing.*;

public class Gui_DeleteForDoctor implements ActionListener {

	JFrame frame;
	JLabel nidl;
	JTextField NID;

	JButton submit;
	JButton cancel;

	public Gui_DeleteForDoctor() {

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
		frame.setTitle("Removal For Doctor");

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {
			String temp = NID.getText();
			int x = Integer.parseInt(temp);
			int j = -1;
			int f=0;// flag
			for (int i = 0; i < Gui_Open.doc.length; i++) {
				if (Gui_Open.doc[i] != null) {
					if (Gui_Open.doc[i].getNid() == x) {
						j = i;
						f=1;
					}
				}
			}
			try{
				if (f == 0) {
					throw new Exception();

				}
				Gui_Open.fdoctorwrite = new FileWriter("Doctor.txt");
				for (int i = 0; i < Gui_Open.patient.length; i++){
					if(Gui_Open.doc[i] != null){
						if(i!=j){
							Gui_Open.fdoctorwrite.append(Gui_Open.doc[i].getName() + "\n" + Gui_Open.doc[i].getGender() + "\n" + Gui_Open.doc[i].getNid() + "\n" + Gui_Open.doc[i].getAge()
							+ "\n" + Gui_Open.doc[i].getPhone() + "\n" + Gui_Open.doc[i].getEmail() + "\n" + Gui_Open.doc[i].getAddress() + "\n" + Gui_Open.doc[i].getRoom() + "\n"
							+ Gui_Open.doc[i].getSalary() + "\n" + Gui_Open.doc[i].getJoin_date() + "\n");
						}
					}
				}
				Gui_Open.fdoctorwrite.close();
				frame.setVisible(false);
				new Gui_DocSelection();
				
			}
			catch(Exception ex){
				frame.setVisible(false);
				new Gui_WrongSearchId();
			}
			
		}

		if (e.getSource() == cancel) {

			frame.setVisible(false);

		}

	}

	public static void main(String[] args) {
		new Gui_DeleteForDoctor();

	}

}
