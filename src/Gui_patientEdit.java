import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Gui_patientEdit implements ActionListener {
	JFrame frame;
	JLabel optionL, nidL;
	JComboBox option;
	JLabel updateL;
	JTextField update, nid;
	JButton submit, cancel;

	public Gui_patientEdit() {
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.PLAIN, 21);

		frame = new JFrame("Edit information of a patient");
		frame.setBounds(280, 150, 750, 400);

		GridLayout g = new GridLayout(4, 2);
		frame.setLayout(g);

		nidL = new JLabel("Patient's NID ");
		nidL.setFont(f1);
		nid = new JTextField();
		nid.setFont(f2);
		String[] x = { "Name", "Address", "Phone", "Email", "Age", "Disease", "Cabil/Ward no" };
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
		cancel = new JButton("<Back");
		cancel.setFont(f1);
		cancel.addActionListener(this);

		frame.add(nidL);
		frame.add(nid);
		frame.add(optionL);
		frame.add(option);
		frame.add(updateL);
		frame.add(update);
		frame.add(submit);
		frame.add(cancel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			String id = nid.getText();
			int nid = Integer.parseInt(id);
			String x = option.getSelectedItem().toString();//Can do but takes time
			
			for(int i=0;i<Gui_Open.patient.length;i++){
				if(Gui_Open.patient[i]!=null){
					if(nid == Gui_Open.patient[i].getNid()){
						
					}
				}
			}
			
			
			
		}
		if (e.getSource() == cancel) {
			frame.setVisible(false);
			new Gui_PatientSelection();
		}

	}

	public static void main(String[] args) {
		new Gui_patientEdit();
	}

}
