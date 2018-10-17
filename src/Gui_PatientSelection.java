import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Gui_PatientSelection implements ActionListener{
	JFrame frame;
	JLabel title;
	JButton add,edit,delete,search,back,exit;
	public Gui_PatientSelection() {
		
		frame = new JFrame("Patient's Selection");
		frame.setBounds(280, 150, 750, 400);
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.PLAIN, 21);
		
		title = new JLabel("                                  Which section you want to enter ?");
		title.setFont(f1);
		title.setForeground(Color.blue);
		
		add = new JButton("ADD Information");
		add.setFont(f2);
		
		search = new JButton("Search");
		search.setFont(f2);
		
		delete = new JButton("Delete");
		delete.setFont(f2);
		
		GridLayout g = new GridLayout(6,1);
		frame.setLayout(g);
		
		frame.add(title);
		frame.add(add);
		add.addActionListener(this);

		
		frame.add(search);
		search.addActionListener(this);
		
		frame.add(delete);
		delete.addActionListener(this);
		back = new JButton("<Back");
		back.setFont(f2);
		back.addActionListener(this);
		frame.add(back);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setFont(f2);
		frame.add(exit);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add){
			frame.setVisible(false);
			new Gui_Patient();
		}
		if(e.getSource()== search){
			frame.setVisible(false);
			new Gui_SearchForPatient();
		}
		if(e.getSource() == delete){
			frame.setVisible(false);
			new Gui_Delete_for_Patient();
		}
		
		if(e.getSource() == exit){
			frame.setVisible(false);
		}
		if(e.getSource() == back){
			frame.setVisible(false);
			new Gui_Selection();
		}
		//the edit window is under developing
		
	}
	public static void main(String[] args) {
		new Gui_PatientSelection();
	}
	
	
	

}
