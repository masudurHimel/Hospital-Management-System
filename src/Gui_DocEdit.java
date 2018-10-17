import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Gui_DocEdit implements ActionListener {
	JFrame frame;
	JLabel optionL, nidL;
	JComboBox option;
	JLabel updateL;
	JTextField update, nid;
	JButton submit, back;

	public Gui_DocEdit() {
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.PLAIN, 21);

		frame = new JFrame("Edit information of a doctor");
		frame.setBounds(280, 150, 750, 400);

		GridLayout g = new GridLayout(4, 2);
		frame.setLayout(g);

		nidL = new JLabel("Doctor's NID ");
		nidL.setFont(f1);
		nid = new JTextField();
		nid.setFont(f2);
		String[] x = { "Name", "Address", "Phone", "Email", "Age","Room No","Salary"};
		optionL = new JLabel("What do you want to Update ?");
		optionL.setFont(f1);
		option = new JComboBox(x);
		option.setFont(f1);

		updateL = new JLabel("Updated Information ");
		updateL.setFont(f1);
		update = new JTextField();
		update.setFont(f2);

		submit = new JButton("Submit");
		submit.setFont(f2);
		submit.addActionListener(this);
		back = new JButton("<Back");
		back.setFont(f1);
		back.addActionListener(this);

		frame.add(nidL);
		frame.add(nid);
		frame.add(optionL);
		frame.add(option);
		frame.add(updateL);
		frame.add(update);
		frame.add(submit);
		frame.add(back);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			frame.setVisible(false);
			new Gui_DocSelection();
		}
		if (e.getSource() == back) {
			frame.setVisible(false);
			new Gui_DocSelection();
		}

	}

	public static void main(String[] args) {
		new Gui_DocEdit();
	}

}
