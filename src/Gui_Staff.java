import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import org.omg.CORBA.INTERNAL;

public class Gui_Staff implements ActionListener {

	JFrame frame;
	JLabel namel;
	JLabel addl;
	JLabel phonel;
	JLabel eml;
	JLabel agel;
	JLabel nidl;
	JLabel posl;

	JLabel salaryl;
	JTextField name;
	JRadioButton m;
	JRadioButton fe;
	ButtonGroup gen;
	JTextField add;
	JTextField phone;
	JTextField em;
	JTextField age;
	JTextField nid;
	JComboBox pos;

	JTextField salary;
	JButton submit;
	JButton cancel;

	public Gui_Staff() {
		Font f = new Font("Arial", Font.BOLD, 21);
		Font ff = new Font("Arial", Font.PLAIN, 21);
		Font f1 = new Font("Arial", Font.PLAIN, 19);

		frame = new JFrame();

		namel = new JLabel(" Name:");
		addl = new JLabel(" Address:");
		phonel = new JLabel(" Phone no.");
		eml = new JLabel(" Email: ");
		nidl = new JLabel(" NID:");
		agel = new JLabel(" Age:");

		salaryl = new JLabel(" Salary:");
		posl = new JLabel(" Position ");
		name = new JTextField();
		m = new JRadioButton(" Male");
		m.setFont(f);
		fe = new JRadioButton(" Female");
		fe.setFont(f);
		gen = new ButtonGroup();
		gen.add(m);
		gen.add(fe);
		add = new JTextField();
		phone = new JTextField();
		em = new JTextField();
		nid = new JTextField();
		age = new JTextField();

		salary = new JTextField();
		String[] options = { "Intern", "Nurse", "Support staff" };
		pos = new JComboBox(options);

		submit = new JButton("Submit");

		submit.addActionListener(this);
		submit.setFont(f1);

		cancel = new JButton("Cancel");
		cancel.setFont(f1);
		cancel.addActionListener(this);

		GridLayout g = new GridLayout(10, 2);
		frame.setLayout(g);
		frame.setBounds(280, 150, 750, 400);

		frame.add(namel);
		frame.add(name);
		frame.add(m);
		frame.add(fe);
		frame.add(posl);
		frame.add(pos);
		frame.add(nidl);
		frame.add(nid);
		frame.add(agel);
		frame.add(age);
		frame.add(phonel);
		frame.add(phone);
		frame.add(eml);
		frame.add(em);
		frame.add(addl);
		frame.add(add);

		frame.add(salaryl);
		frame.add(salary);

		frame.add(submit);
		frame.add(cancel);

		frame.setTitle("Staff's Form");

		namel.setFont(f);
		addl.setFont(f);
		phonel.setFont(f);
		agel.setFont(f);
		eml.setFont(f);
		nidl.setFont(f);
		posl.setFont(f);

		salaryl.setFont(f);

		name.setFont(ff);
		add.setFont(ff);
		phone.setFont(ff);
		age.setFont(ff);
		em.setFont(ff);
		nid.setFont(ff);
		pos.setFont(ff);

		salary.setFont(ff);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {
			try {
				String n = name.getText();
				String a = add.getText();
				String p = phone.getText();
				String email = em.getText();
				int ag = Integer.parseInt(age.getText());
				int id = Integer.parseInt(nid.getText());
				String position = pos.getSelectedItem().toString();
				Date joindate = new Date();
				double s = Double.parseDouble(salary.getText());
				m.setActionCommand("Male");
				fe.setActionCommand("Female");

				String gender = gen.getSelection().getActionCommand();

				Staff t = new Staff(n, a, p, email, ag, id, position, joindate, s, gender);
				
				Gui_Open.fstaffwrite.append(t.getName() + "\n" + t.getGender() + "\n" + t.getPosition() + "\n"
						+ t.getNid() + "\n" + t.getAge() + "\n" + t.getPhone() + "\n" + t.getEmail() + "\n"
						+ t.getAddress() + "\n" + t.getSalary() + "\n" + t.getJoin_date()+"\n");
				

				frame.setVisible(false);
				new Gui_Added5forStaff();
			} catch (Exception ex) {
				ex.printStackTrace();
				frame.setVisible(false);
				new Gui_WrongInput2Staff();
			}

		}

		if (e.getSource() == cancel) {

			frame.setVisible(false);

		}

	}

	public static void main(String[] args) {
		new Gui_Staff();
	}

}
