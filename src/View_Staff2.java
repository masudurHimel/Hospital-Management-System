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

public class View_Staff2 implements ActionListener {
	JFrame frame;
	JLabel nameL, genderL, nidL, ageL, phoneL, emailL, addressL, positionL, salaryL;
	JTextField name, gender, nid, age, phone, email, address, position, salary;
	JButton back,exit;

	public View_Staff2(String n, String g, String id, String a, String p, String em, String ad, String pos, String s) {

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
		positionL = new JLabel("Position");
		positionL.setFont(f1);
		salaryL = new JLabel("Salary");
		salaryL.setFont(f1);
		
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
		position = new JTextField(pos);
		position.setEditable(false);
		salary = new JTextField(s);
		salary.setEditable(false);
		
		
		GridLayout layout = new GridLayout(10,2);
		frame.setLayout(layout);
		
		frame.add(nameL);
		frame.add(name);
		frame.add(genderL);
		frame.add(gender);
		frame.add(nidL);
		frame.add(nid);
		frame.add(positionL);
		frame.add(position);
		frame.add(ageL);
		frame.add(age);
		frame.add(phoneL);
		frame.add(phone);
		frame.add(emailL);
		frame.add(email);
		frame.add(addressL);
		frame.add(address);
		
		frame.add(salaryL);
		frame.add(salary);
		frame.add(back);
		frame.add(exit);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
			frame.setVisible(false);
			new Gui_Reception();
		}
		if(e.getSource() == exit){
			frame.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new View_Staff2(null, null, null, null, null, null, null, null, null);
	}


}
