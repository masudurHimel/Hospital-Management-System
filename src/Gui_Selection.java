import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui_Selection implements ActionListener {
	JFrame frame;
	JLabel title;
	JButton staff, doctor, patient, exit, settings;

	public Gui_Selection() {
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.BOLD, 25);

		frame = new JFrame("Option");
		GridLayout g = new GridLayout(6, 1, 0, 10);

		frame.setLayout(g);

		title = new JLabel("                         Which section you want to Enter ?");
		title.setFont(f2);
		title.setForeground(Color.BLUE);

		staff = new JButton(" Staff ");
		staff.setFont(f1);
		staff.addActionListener(this);
		
		doctor = new JButton("Doctor");
		doctor.setFont(f1);
		doctor.addActionListener(this);

		patient = new JButton("Patient");
		patient.setFont(f1);
		patient.addActionListener(this);

		exit = new JButton("Exit");
		exit.setFont(f1);
		exit.addActionListener(this);

		settings = new JButton("Settings");
		settings.setFont(f1);
		settings.addActionListener(this);

		frame.add(title);
		frame.add(staff);
		frame.add(doctor);
		frame.add(patient);
		frame.add(settings);
		frame.add(exit);

		frame.setVisible(true);
		frame.setBounds(280, 150, 750, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Gui_Selection();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == staff) {
			frame.setVisible(false);
			new Gui_StaffSelection();
		}
		if(e.getSource() == doctor){
			frame.setVisible(false);
			new Gui_DocSelection();
		}
		if (e.getSource() == patient) {
			frame.setVisible(false);
			new Gui_PatientSelection();
		}
		if (e.getSource() == exit) {
			frame.setVisible(false);
		}
		if (e.getSource() == settings) {
			frame.setVisible(false);
			new Gui_Settings();
		}
	}

}
