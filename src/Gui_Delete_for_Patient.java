import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.*;

public class Gui_Delete_for_Patient implements ActionListener {

	JFrame frame;
	JLabel nidl;
	JTextField NID;

	JButton submit;
	JButton cancel;

	public Gui_Delete_for_Patient() {

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
		frame.setTitle("Removal For Patient");

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {

			String temp = NID.getText();
			int x = Integer.parseInt(temp);
			int j = -1;
			int f = 0;// flag
			for (int i = 0; i < Gui_Open.patient.length; i++) {
				if (Gui_Open.patient[i] != null) {
					if (Gui_Open.patient[i].getNid() == x) {
						j = i;
						f = 1;
					}
				}
			}

			try {
				if (f == 0) {
					throw new Exception();

				}
				Gui_Open.fpatientwrite = new FileWriter("Patient.txt");
				for (int i = 0; i < Gui_Open.patient.length; i++) {
					if (Gui_Open.patient[i] != null) {
						if (i != j) {
							Gui_Open.fpatientwrite.append(Gui_Open.patient[i].getName() + "\n"
									+ Gui_Open.patient[i].getGender() + "\n" + Gui_Open.patient[i].getNid() + "\n"
									+ Gui_Open.patient[i].getAge() + "\n" + Gui_Open.patient[i].getPhone() + "\n"
									+ Gui_Open.patient[i].getEmail() + "\n" + Gui_Open.patient[i].getAddress() + "\n"
									+ Gui_Open.patient[i].getDisease() + "\n" + Gui_Open.patient[i].getCabinType()
									+ "\n" + Gui_Open.patient[i].getCabin() + "\n" + Gui_Open.patient[i].getadmitDate()
									+ "\n");
							

						}
					}

				}
				Gui_Open.fpatientwrite.close();
				frame.setVisible(false);
				new Gui_PatientSelection();

			} catch (Exception e1) {
				frame.setVisible(false);
				new Gui_WrongSearchId();
			}

		}

		if (e.getSource() == cancel) {

			frame.setVisible(false);

		}

	}

	public static void main(String[] args) {
		new Gui_Delete_for_Patient();

	}

}
