import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;

public class Gui_Open implements ActionListener {
	
	
	JFrame frame;
	JButton doctor, admin, reception, cancel;
	static int index =0;
	
	static Patient[] patient;
	static File fpatientread;
	static FileWriter fpatientwrite;
	
	static Doctor[] doc;
	static File fdoctorread;
	static FileWriter fdoctorwrite;
	
	static Staff[] staff;
	static File fstaffread;
	static FileWriter fstaffwrite;
	
	
	public Gui_Open() {
		frame = new JFrame("Choose your field");
		Font f1 = new Font("Arial", Font.BOLD, 21);
		Font f2 = new Font("Arial", Font.PLAIN, 21);
		frame.setBounds(280, 150, 750, 400);
		GridLayout g = new GridLayout(4, 1);
		frame.setLayout(g);

		doctor = new JButton("Doctor");
		doctor.addActionListener(this);
		doctor.setFont(f1);
		admin = new JButton("Admin");
		admin.setFont(f1);
		admin.addActionListener(this);
		reception = new JButton("Reception");
		reception.setFont(f1);
		reception.addActionListener(this);
		cancel = new JButton("Exit");
		cancel.setFont(f1);
		cancel.addActionListener(this);

		frame.add(admin);

		frame.add(doctor);

		frame.add(reception);
		frame.add(cancel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == admin) {
			
			frame.setVisible(false);
			new Gui_pass1();
		}
		if (e.getSource() == doctor) {
			frame.setVisible(false);
			new Gui_PassDoc();
		}
		if (e.getSource() == reception) {
			frame.setVisible(false);
			new Gui_ReceptionPass();
		}
		if (e.getSource() == cancel) {
			frame.setVisible(false);
		}

	}

	public static void main(String[] args) {
		new Gui_Open();
		
		
		try{//for patient
			fpatientwrite = new FileWriter("Patient.txt",true);
			fpatientread = new File("Patient.txt");
			Scanner read = new Scanner(fpatientread);
			patient = new Patient[10000];
			int x=0;
			
	
			while(read.hasNextLine()==true){
				
				String name = read.nextLine();
				String gender = read.nextLine();
				String id = read.nextLine();//id string
				int nid = Integer.parseInt(id);
				String a = read.nextLine();//age string
				int age = Integer.parseInt(a);
				String phone = read.nextLine();
				String email = read.nextLine();
				String address = read.nextLine();
				String disease = read.nextLine();
				String type = read.nextLine();
				
				String cno = read.nextLine();
				
				int cabinNo = Integer.parseInt(cno);
				
				String admitDate = read.nextLine();
				
				Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(admitDate);
				
				Patient temp = new Patient(name, address, phone, email, age, nid, disease, cabinNo, date, gender, type);
				patient[x] = temp;
				x++;
				
			}

			
			
		}
		catch(Exception ex){
			
		}
		
		try{//for doc
			fdoctorwrite = new FileWriter("Doctor.txt",true);
			fdoctorread = new File("Doctor.txt");
			Scanner read = new Scanner(fdoctorread);
			int x=0;
			doc = new Doctor[10000];
			while(read.hasNextLine()==true){
				String name = read.nextLine();
				String gender = read.nextLine();
				String id = read.nextLine();//id string
				int nid = Integer.parseInt(id);
				String a = read.nextLine();//age string
				int age = Integer.parseInt(a);
				String phone = read.nextLine();
				String email = read.nextLine();
				String address = read.nextLine();
				String room = read.nextLine();
				String s = read.nextLine();
				double salary = Double.parseDouble(s);
				String jdate  = read.nextLine();
				Date joinDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(jdate);
				
				Doctor temp = new Doctor(name, address, phone, email, age, nid, room, joinDate, salary, gender);
				doc[x] = temp;
				x++;
			
			}
		
		}
		catch(Exception ex){
			
		}
		
		try{//for staff
			fstaffwrite = new FileWriter("Staff.txt",true);
			fstaffread = new File("Staff.txt");
			Scanner read = new Scanner(fstaffread);
			int x=0;
			staff = new Staff[10000];
			while(read.hasNextLine()==true){
				String name = read.nextLine();
				String gender = read.nextLine();
				String position = read.nextLine();
				String id = read.nextLine();
				int nid = Integer.parseInt(id);
				String a = read.nextLine();//age string
				int age = Integer.parseInt(a);
				String phone = read.nextLine();
				String email = read.nextLine();
				String address = read.nextLine();
				String s = read.nextLine();
				double salary = Double.parseDouble(s);
				String jdate  = read.nextLine();
				Date joinDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(jdate);
				
				Staff temp = new Staff(name, address, phone, email, age, nid, position, joinDate, salary, gender);
				staff[x]=temp;
				x++;
				
			}

		}
		catch(Exception ex){
			
		}
		
		
		
	}
}
