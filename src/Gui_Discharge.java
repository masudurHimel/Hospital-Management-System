import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui_Discharge implements ActionListener {
	JFrame frame;
	JLabel title,ending,bill;
	JButton menu;
	
	public Gui_Discharge(double o){
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.BOLD, 25);

		frame = new JFrame("Dischage");
		frame.setBounds(280, 150, 750, 400);

		GridLayout g = new GridLayout(4, 1);
		frame.setLayout(g);
		
		title = new JLabel("                                      Discharge Bill");
		title.setFont(f2);
		title.setForeground(Color.BLUE);
		
		bill = new JLabel("                                  Your total bill is "+o+" Tk only");
		bill.setFont(f1);
		
		ending = new JLabel("                                                  "
				+ "                              **Please Visit the Admin with this bill**");
		
		menu = new JButton("Main Menu");
		menu.addActionListener(this);
		
		frame.add(title);
		frame.add(bill);
		frame.add(ending);
		frame.add(menu);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu){
			frame.setVisible(false);
			new Gui_Reception();
		}
		
	}
	
	public static void main(String[] args) {
		new Gui_Discharge(8500);
	}
	
	

}
