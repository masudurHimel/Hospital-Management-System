import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Gui_SearchForPatient2 implements ActionListener {

	JFrame frame;
	JLabel nidl;
	JTextField NID;

	JButton submit;
	JButton cancel;

	public Gui_SearchForPatient2() {

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
		frame.setTitle("Search For Patient");

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {
			
			String temp = NID.getText();
			int x = Integer.parseInt(temp);
			int j=0;//flag
			for (int i = 0; i < Gui_Open.patient.length; i++) {
				if (Gui_Open.patient[i] != null) {
					if (Gui_Open.patient[i].getNid() == x) {
						j=1;
						String nid = "" + Gui_Open.patient[i].getNid();
						String AGE = "" + Gui_Open.patient[i].getAge();
						String Cabin = "" + Gui_Open.patient[i].getCabin();
						frame.setVisible(false);
						new View_Patient2(Gui_Open.patient[i].getName(), Gui_Open.patient[i].getGender(), nid, AGE,
								Gui_Open.patient[i].getPhone(), Gui_Open.patient[i].getEmail(),
								Gui_Open.patient[i].getAddress(), Gui_Open.patient[i].getDisease(),
								Gui_Open.patient[i].getCabinType(), Cabin);
						break;
					}
				}
			}
			if(j==0){
				frame.setVisible(false);
				new Gui_WrongSearchId2();
			}
			
		}

		if (e.getSource() == cancel) {

			frame.setVisible(false);

		}

	}

	public static void main(String[] args) {
		new Gui_SearchForPatient2();

	}

}
