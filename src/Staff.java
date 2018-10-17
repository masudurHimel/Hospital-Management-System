import java.io.IOException;
import java.util.Date;

public class Staff extends Person {
	private String position, gender;
	private java.util.Date join_date;
	private java.util.Date resign_date = null;// in case if there is no
												// resignation;
	private double salary;

	public Staff(String name, String address, String phone, String email, int age, int nid, String position,
			Date join_date, double salary, String gender) {
		super(name, address, phone, email, age, nid);
		this.position = position;
		this.join_date = join_date;
		this.salary = salary;
		this.gender = gender;
		
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public java.util.Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(java.util.Date join_date) {
		this.join_date = join_date;
	}

	

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [position=" + position + ", gender=" + gender + ", join_date=" + join_date +  " salary=" + salary + "]";
	}

	
}
