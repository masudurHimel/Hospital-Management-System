import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class View_Patient2 implements ActionListener {
	JFrame frame;
	JLabel nameL, genderL, nidL, ageL, phoneL, emailL, addressL, diseaseL, cabinTypeL, cabinNoL;
	JTextField name, gender, nid, age, phone, email, address, disease, cabinType, cabinNo;
	JButton back,exit;

	public View_Patient2(String n, String g, String id, String a, String p, String em, String ad, String d, String ct,
			String cn) {

		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.PLAIN, 21);

		frame = new JFrame("Seached Patient");
		frame.setBounds(280, 150, 750, 400);
		nameL = new JLabel("Name");
		nameL.setFont(f1);
		genderL = new JLabel("Gender");
		genderL.setFont(f1);
		nidL = new JLabel("NID");
		nidL.setFont(f1);
		ageL = new JLabel("Age");
		ageL.setFont(f1);
		phoneL = new JLabel("Phone");
		phoneL.setFont(f1);
		emailL = new JLabel("Email");
		emailL.setFont(f1);
		addressL = new JLabel("Address");
		addressL.setFont(f1);
		diseaseL = new JLabel("Disease");
		diseaseL.setFont(f1);
		cabinTypeL = new JLabel("Room type");
		cabinTypeL.setFont(f1);
		cabinNoL = new JLabel("Room No");
		cabinNoL.setFont(f1);
		
		back = new JButton("<Back");
		back.addActionListener(this);
		back.setFont(f1);
		exit = new  JButton("Exit");
		exit.addActionListener(this);
		exit.setFont(f1);
		
		
		name = new JTextField(n);
		name.setEditable(false);
		gender = new JTextField(g);
		gender.setEditable(false);
		nid = new JTextField(id);
		nid.setEditable(false);
		age = new JTextField(a);
		age.setEditable(false);
		phone = new JTextField(p);
		phone.setEditable(false);
		email  = new JTextField(em);
		email.setEditable(false);
		address = new JTextField(ad);
		address.setEditable(false);
		disease = new JTextField(d);
		disease.setEditable(false);
		cabinType = new JTextField(ct);
		cabinType.setEditable(false);
		cabinNo = new JTextField(cn);
		cabinNo.setEditable(false);
		
		GridLayout layout = new GridLayout(11,2);
		frame.setLayout(layout);
		
		frame.add(nameL);
		frame.add(name);
		frame.add(genderL);
		frame.add(gender);
		frame.add(nidL);
		frame.add(nid);
		frame.add(ageL);
		frame.add(age);
		frame.add(phoneL);
		frame.add(phone);
		frame.add(emailL);
		frame.add(email);
		frame.add(addressL);
		frame.add(address);
		frame.add(diseaseL);
		frame.add(disease);
		frame.add(cabinTypeL);
		frame.add(cabinType);
		frame.add(cabinNoL);
		frame.add(cabinNo);
		frame.add(back);
		frame.add(exit);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
			frame.setVisible(false);
			new GUI_optionDoc();
		}
		if(e.getSource() == exit){
			frame.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new View_Patient2(null, null, null, null, null, null, null, null, null, null);
	}


}
