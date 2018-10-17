import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui_Reception implements ActionListener{
	JFrame frame;
	JButton patient,staff,discharge,exit;
	JLabel title;
	public Gui_Reception(){
		frame = new JFrame("Reception's Area");
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.BOLD, 25);
		frame.setBounds(280, 150, 750, 400);
		GridLayout g = new GridLayout(5, 1,0,10);
		frame.setLayout(g);
		
		patient = new JButton("Search Patient");
		patient.addActionListener(this);
		patient.setFont(f1);
		
		staff = new JButton("Search Staff");
		staff.addActionListener(this);
		staff.setFont(f1);
		
		discharge = new JButton("Discharge");
		discharge.addActionListener(this);
		discharge.setFont(f1);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setFont(f1);
		
		title = new JLabel("                                      Reception's Area");
		title.setFont(f2);
		title.setForeground(Color.blue);
		
		frame.add(title);
		frame.add(patient);
		frame.add(discharge);
		frame.add(staff);
		frame.add(exit);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == patient){
			frame.setVisible(false);
			new Gui_SearchForPatient3();
			
		}
		if(e.getSource() == discharge){
			frame.setVisible(false);
			new Gui_SearchForPatient4();
		}
		if(e.getSource() == staff){
			frame.setVisible(false);
			new Gui_SearchforStaff2();
		}
		if(e.getSource()==exit){
			frame.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new Gui_Reception();
	}

}
