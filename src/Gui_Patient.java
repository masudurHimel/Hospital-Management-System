import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.ws.WebServiceException;

public class Gui_Patient implements ActionListener {
	JFrame frame;
	JLabel nameL, addressL, phoneL, emailL, ageL, nidL, diseaseL, cabinL;
	JTextField name, address, phone, email, age, nid, disease, cabin;
	JButton add, cancel;
	JRadioButton male, female, cabino, wardo;
	ButtonGroup gender, ctype;

	public Gui_Patient() {
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.PLAIN, 21);

		frame = new JFrame("Patients Form");
		frame.setBounds(280, 150, 750, 400);

		nameL = new JLabel("Name");
		nameL.setFont(f1);

		addressL = new JLabel("Address");
		addressL.setFont(f1);

		phoneL = new JLabel("Phone no.");
		phoneL.setFont(f1);

		emailL = new JLabel("Email");
		emailL.setFont(f1);

		ageL = new JLabel("Age");
		ageL.setFont(f1);

		nidL = new JLabel("NID");
		nidL.setFont(f1);

		diseaseL = new JLabel("Disease");
		diseaseL.setFont(f1);

		cabinL = new JLabel("Cabin/Ward Number ");
		cabinL.setFont(f1);

		name = new JTextField();
		name.setFont(f2);

		male = new JRadioButton("Male");
		male.setFont(f1);
		female = new JRadioButton("Female");
		female.setFont(f1);
		gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);

		cabino = new JRadioButton("Cabin");
		cabino.setFont(f1);
		wardo = new JRadioButton("Ward");
		wardo.setFont(f1);
		ctype = new ButtonGroup();
		ctype.add(cabino);
		ctype.add(wardo);

		address = new JTextField();
		address.setFont(f2);

		phone = new JTextField();
		phone.setFont(f2);

		email = new JTextField();
		email.setFont(f2);

		age = new JTextField();
		age.setFont(f2);

		nid = new JTextField();
		nid.setFont(f2);

		disease = new JTextField();
		disease.setFont(f2);

		cabin = new JTextField();
		cabin.setFont(f2);

		add = new JButton("Add");
		add.setFont(f2);
		add.addActionListener(this);

		cancel = new JButton("Cancel");
		cancel.setFont(f2);
		cancel.addActionListener(this);

		GridLayout g = new GridLayout(11, 2);
		frame.setLayout(g);

		frame.add(nameL);
		frame.add(name);
		frame.add(male);
		frame.add(female);
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
		frame.add(cabino);
		frame.add(wardo);
		frame.add(cabinL);
		frame.add(cabin);
		frame.add(add);
		frame.add(cancel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == add) {
			try {
				String n = name.getText();
				String a = address.getText();
				String p = phone.getText();
				String em = email.getText();
				int ag = Integer.parseInt(age.getText());
				int id = Integer.parseInt(nid.getText());
				String d = disease.getText();
				int c = Integer.parseInt(cabin.getText());
				java.util.Date admitDate = new Date();

				male.setActionCommand("Male");
				female.setActionCommand("Female");

				String g = gender.getSelection().getActionCommand();

				cabino.setActionCommand("Cabin");
				wardo.setActionCommand("Ward");

				String type = ctype.getSelection().getActionCommand();

				Patient t = new Patient(n, a, p, em, ag, id, d, c, admitDate, g, type);

				Gui_Open.fpatientwrite.append(t.getName() + "\n" + t.getGender()
						+ "\n" + t.getNid() + "\n" +t.getAge() + "\n"
						+t.getPhone() + "\n" + t.getEmail() + "\n"
						+ t.getAddress() + "\n" +t.getDisease() + "\n"
						+ t.getCabinType() + "\n" +t.getCabin() + "\n"
						+ t.getadmitDate()+"\n");

				

				
				

				frame.setVisible(false);
				new GUI_Added4();
			} catch (Exception ex) {
				frame.setVisible(false);
				System.out.println(ex);
				new Gui_WrongInput();
			}

		}
		if (e.getSource() == cancel) {
			frame.setVisible(false);
			
		}

	}

	public static void main(String[] args) {
		new Gui_Patient();
	}

}
