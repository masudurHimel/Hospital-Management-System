import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.Attributes.Name;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Gui_Settings implements ActionListener {
	JFrame frame ;
	JLabel newusernameL,oldpassL,newpassL;
	JTextField newusername,oldpass;
	JPasswordField newpass;
	JButton submit,cancel;
	public Gui_Settings(){
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.PLAIN, 21);
		
		frame = new JFrame("Settings");
		frame.setBounds(280, 150, 750, 400);
		newusernameL = new JLabel("  New Username ");
		newusernameL.setFont(f1);
		newusername = new JTextField();
		newusername.setFont(f2);
		
		oldpassL = new  JLabel("  Old Password");
		oldpassL.setFont(f1);
		oldpass = new JTextField();
		oldpass.setFont(f2);
		
		newpassL = new JLabel("  New Password");
		newpassL.setFont(f1);
		newpass = new JPasswordField();
		newpass.setFont(f2);
		
		submit = new JButton("Submit");
		submit.setFont(f2);
		submit.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setFont(f2);
		cancel.addActionListener(this);
		
		GridLayout g = new GridLayout(4,2);
		frame.setLayout(g);
		
		frame.add(newusernameL);
		frame.add(newusername);
		frame.add(oldpassL);
		frame.add(oldpass);
		frame.add(newpassL);
		frame.add(newpass);
		frame.add(submit);
		frame.add(cancel);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit){
			frame.setVisible(false);
			try{
				String username = newusername.getText();
				String passwordOld = oldpass.getText();
				String passwordNew = newpass.getText();
				if(passwordOld.equals(Settings.pwdb)){
					Settings s1 = new Settings(username, passwordNew);
					System.out.println(s1.toString());
					s1.setPwdb(s1.getPwdu());
				
				}
				
			}
			catch(Exception ex){
				System.out.println("Wrong !!");
			}
			new Gui_Selection();
		}
		if(e.getSource() == cancel){
			frame.setVisible(false);
			new Gui_Selection();
		}
		
	}
	public static void main(String[] args) {
		new Gui_Settings();
	}
	

}
