import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Gui_SearchForPatient4 implements ActionListener {

	JFrame frame;
	JLabel nidl,costingL;
	JTextField NID,costing;

	JButton submit;
	JButton cancel;

	public Gui_SearchForPatient4() {

		Font f = new Font("Arial", Font.BOLD, 21);
		Font ff = new Font("Arial", Font.PLAIN, 21);

		frame = new JFrame();
		nidl = new JLabel("                          NID");
		NID = new JTextField();
		costingL = new JLabel("           Extra Cost until today");
		costing = new JTextField();
		submit = new JButton("submit");
		submit.addActionListener(this);
		cancel = new JButton("cancel");
		cancel.addActionListener(this);

		frame.add(nidl);
		frame.add(NID);
		frame.add(costingL);
		frame.add(costing);
		frame.add(submit);
		frame.add(cancel);
		nidl.setFont(f);
		NID.setFont(ff);
		costing.setFont(ff);
		costingL.setFont(f);

		submit.setFont(f);
		cancel.setFont(f);

		GridLayout g = new GridLayout(3, 2);
		frame.setLayout(g);
		frame.setBounds(280, 150, 750, 400);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Discharge Bill");

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {
			String m = costing.getText();
			double otherCosting = Double.parseDouble(m);

			String temp = NID.getText();
			int x = Integer.parseInt(temp);
			int j = 0;// flag
			for (int i = 0; i < Gui_Open.patient.length; i++) {
				if (Gui_Open.patient[i] != null) {
					if (Gui_Open.patient[i].getNid() == x) {
						j=1;
						double o =Gui_Open.patient[i].dis_amount(Gui_Open.patient[i].getadmitDate(), new Date(),
								Gui_Open.patient[i].getCabinType(), otherCosting);
						frame.setVisible(false);
						new Gui_Discharge(o);
					}
				}
			}
			if (j == 0) {
				frame.setVisible(false);
				new Gui_WrongSearchId3();
			}

		}

		if (e.getSource() == cancel) {

			frame.setVisible(false);

		}

	}

	public static void main(String[] args) {
		new Gui_SearchForPatient4();

	}

}
