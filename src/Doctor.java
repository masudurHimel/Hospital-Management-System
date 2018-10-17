
import java.util.Date;

public class Doctor extends Person {
	private String gender;
	private java.util.Date join_date;
	private java.util.Date resign_date = null;// in case if there is no
												// resignation;
	private double salary;
	private String room;
	public static int doc_no = 0;

	public Doctor(String name, String address, String phone, String email, int age, int nid, String room,
			Date join_date, double salary, String gender) {
		super(name, address, phone, email, age, nid);

		this.join_date = join_date;
		this.salary = salary;
		this.gender = gender;
		this.room = room;
		doc_no++;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.util.Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(java.util.Date join_date) {
		this.join_date = join_date;
	}

	public java.util.Date getResign_date() {
		return resign_date;
	}

	public void setResign_date(java.util.Date resign_date) {
		this.resign_date = resign_date;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Doctor [gender=" + gender + ", join_date=" + join_date + ", resign_date=" + resign_date + ", salary="
				+ salary + ", room=" + room + ", getName()=" + getName() + ", getAddress()=" + getAddress()
				+ ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + ", getAge()=" + getAge() + ", getNid()="
				+ getNid() + "]";
	}

}
