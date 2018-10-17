import java.io.FileWriter;
import java.io.IOException;

public class Person {
	private  String name,address,phone,email;
	private int age,nid;
	
	protected Person(String name, String address, String phone, String email, int age, int nid){
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.nid = nid;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}
	
	
	
	
	

}
